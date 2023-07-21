package com.example.lab16.test1

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.lab16.databinding.ActivityTest1Binding

class Test1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTest1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val cursor = contentResolver.query(
                Uri.parse("content://com.my.provider"),
            null, null, null, null, null)

            while (cursor?.moveToNext() ?: false) {
                Log.d("eun", cursor?.getString(0) ?: "")

            }
        }
    }
}