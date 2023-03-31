package com.example.lab7.test3

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.lab7.databinding.ActivityTest3Binding

class Test3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTest3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            binding.button.visibility = View.INVISIBLE
            binding.imageVidw.visibility = View.VISIBLE
        }

        binding.imageVidw.setOnClickListener{
            binding.button.visibility = View.VISIBLE
            binding.imageVidw.visibility = View.INVISIBLE
        }

    }
}