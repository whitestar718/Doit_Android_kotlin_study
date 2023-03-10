package com.example.lab6.test5

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.lab6.databinding.ActivityTest6Binding

class Test6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTest6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.visibleBtn.setOnClickListener{
            binding.targetView.visibility = View.VISIBLE
        }
        binding.invisibleBtn.setOnClickListener{
            binding.targetView.visibility = View.INVISIBLE
        }
    }
}