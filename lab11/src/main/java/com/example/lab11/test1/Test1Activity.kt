package com.example.lab11.test1

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.lab11.R
import com.example.lab11.databinding.ActivityTest1Binding

class Test1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTest1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_test, menu)
        val menuItem = menu?.findItem(R.id.menu3)
        val searchView = menuItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            // 글자 하나하나 입력될 때 마다 실행
            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

            // 최종 처리
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
        } )
        return super.onCreateOptionsMenu(menu)
    }
}