package com.example.lab10.test3

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.lab10.databinding.ActivityTest3Binding
import com.example.lab10.databinding.DialogInputBinding

class Test3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTest3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val items = arrayOf("사과", "복숭아", "배")
            AlertDialog.Builder(this).run {
                setTitle("items test")
                setIcon(android.R.drawable.ic_dialog_alert)
                setMultiChoiceItems(
                    items,
                    booleanArrayOf(true, false, true),
                    object : DialogInterface.OnMultiChoiceClickListener {
                        override fun onClick(
                            dialog: DialogInterface?,
                            which: Int,
                            isChecked: Boolean
                        ) {
                            Log.d("eun", "${items[which]} 이 ${if (isChecked) "선택되었습니다." else "선택해제 되었습니다."} ")
                        }
                    }
                )
                setPositiveButton("닫기", null)
                show()
            }
        }

        binding.button2.setOnClickListener {
            val dialogBinding = DialogInputBinding.inflate(layoutInflater)
            AlertDialog.Builder(this).run {
                setTitle("input")
                setView(dialogBinding.root) // 그냥 binding이 아니라, dialogBinding으로 지정해야 함.
                setPositiveButton("닫기", null)
                show()
            }
        }
    }
}