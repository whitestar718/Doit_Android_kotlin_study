package com.example.lab16.test2

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.lab16.databinding.ActivityTest2Binding

/*
* 주소록 연동
* */
class Test2Activity : AppCompatActivity() {

    lateinit var binding: ActivityTest2Binding
    lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    lateinit var intentLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTest2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 퍼미션 조정 요청
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            for (entry in it.entries){
                if (entry.key == "android.permission.READ_CONTACTS" && entry.value) {
                    // 주소록 목록 띄우기
                    val intent = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
                    intentLauncher.launch(intent)
                } else {
                    Toast.makeText(this, "required permission..", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // 주소록에 다시 세부 데이터 요청
        intentLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == RESULT_OK) { // 주소록에서 되돌아 왔는데, 정상처리되었다면
                val cursor = contentResolver.query(
                    it!!.data!!.data!!,
                    arrayOf(
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, // 사람 이름
                        ContactsContract.CommonDataKinds.Phone.NUMBER // 전화번호
                    ),
                    null, null, null
                )

                if (cursor!!.moveToFirst()) {
                    binding.textView.text = "name: ${cursor?.getString(0)}, phone: ${cursor?.getString(1)}"
                }
            }
        }

        // 버튼 이벤트 등록하기
        binding.button.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    "android.permission.READ_CONTACTS"
            ) != PackageManager.PERMISSION_GRANTED) {
                permissionLauncher.launch(arrayOf("android.permission.READ_CONTACTS"))
            } else {
                 // 주소록 목록 띄우기
                val intent = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
                intentLauncher.launch(intent)
            }
        }
    }
}