package com.example.lab10.test1

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.lab10.R

class Test1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test1)

        val requestLaundher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                Log.d("eun", "callback... granted...")
            } else {
                Log.d("eun", "callback... denied...")
            }
        }

        val status = ContextCompat.checkSelfPermission(this,
            "android.permission.ACCESS_FINE_LOCATION")
        if (status == PackageManager.PERMISSION_GRANTED) {
            Log.d("eun", "granted")
        } else {
            requestLaundher.launch("android.permission.ACCESS_FINE_LOCATION")
        }
    }
}