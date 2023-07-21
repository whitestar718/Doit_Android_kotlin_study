package com.example.lab17.test1

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.lab17.databinding.ActivityTest1Binding

class Test1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTest1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // open database
        val db = openOrCreateDatabase("testdb", Context.MODE_PRIVATE, null)

        try {
            db.execSQL("create table USER_TB (" +
                    "_id integer primary key autoincrement," +
                    "name not null," +
                    "phone)")

            db.execSQL("insert into USER_TB (name, phone) values (?,?)",
                    arrayOf("eun", "01000011"))

            db.execSQL("insert into USER_TB (name, phone) values (?,?)",
                arrayOf("kim", "0100002261"))

        } catch (e: Exception) {

        }

        binding.button.setOnClickListener {
            val cursor = db.rawQuery("select * from USER_TB", null)
            while (cursor.moveToNext()) {
                val name = cursor.getString(0)
                val phone = cursor.getString(1)
                Log.d("eun", "$name, $phone")
            }
        }
    }
}