package com.example.lab18.test3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab18.databinding.ActivityTest3Binding
import com.example.test18.retrofit2.MyAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Test3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTest3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val networkService = (applicationContext as MyApplication).networkService

        val userListCall = networkService.doGetUserList("1")
        userListCall.enqueue(object : Callback<UserListModel>{
            override fun onResponse(call: Call<UserListModel>, response: Response<UserListModel>) {
                val userList = response.body()

                binding.recyclerView.adapter = MyAdapter(this@Test3Activity, userList?.data)
                binding.recyclerView.addItemDecoration(
                    DividerItemDecoration(this@Test3Activity, LinearLayoutManager.VERTICAL)
                )
            }

            override fun onFailure(call: Call<UserListModel>, t: Throwable) {
                call.cancel()
            }
        }

        )
    }
}