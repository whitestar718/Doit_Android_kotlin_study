package com.example.lab6.test3

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lab6.R

class Test4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test4)

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)

        button1.setOnClickListener{
            button2.visibility = View.VISIBLE
        }
        button2.setOnClickListener{}
        button3.setOnClickListener{
            button2.visibility = View.INVISIBLE
        }
    }
}