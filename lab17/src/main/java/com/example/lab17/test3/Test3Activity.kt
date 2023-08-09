package com.example.lab17.test3

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.lab17.databinding.ActivityTest3Binding

class Test3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTest3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPrefs = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

        binding.button1.setOnClickListener {
            sharedPrefs.edit().run {
                putString("data1", "hello")
                putInt("data2", 10)
                commit()
            }
        }

        binding.button2.setOnClickListener {
            val data1 = sharedPrefs.getString("data1", "world")
            val data2 = sharedPrefs.getInt("data2", 0)

            Log.d("data1", data1.toString())
            Log.d("data2", data2.toString())
        }


    }
}