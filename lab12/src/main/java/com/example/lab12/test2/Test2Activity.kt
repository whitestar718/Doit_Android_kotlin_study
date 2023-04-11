package com.example.lab12.test2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab12.OneFragment
import com.example.lab12.R
import com.example.lab12.ThreeFragment
import com.example.lab12.TwoFragment
import com.example.lab12.databinding.ActivityTest2Binding
import com.google.android.material.tabs.TabLayout

class Test2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTest2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 초기 화면
        supportFragmentManager.beginTransaction().add(R.id.tapContent, OneFragment()).commit()

        binding.tabs.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when (tab?.text) {
                    "Tab1" -> transaction.replace(R.id.tapContent, OneFragment())
                    "Tab2" -> transaction.replace(R.id.tapContent, TwoFragment())
                    "Tab3" -> transaction.replace(R.id.tapContent, ThreeFragment())
                }
                transaction.commit() // 커밋하고 나면 종료된다. 그래서 다시 얻어야 한다.
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }


        })
    }
}