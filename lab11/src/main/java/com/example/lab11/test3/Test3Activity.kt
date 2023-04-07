package com.example.lab11.test3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab11.databinding.ActivityTest3Binding
import com.example.lab11.databinding.ItemBinding

class Test3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTest3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = mutableListOf<String>()
        for (i in 1..10){
            data.add("Item $i")
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MyAdapter(data)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }
}

class MyViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)

class MyAdapter(val data: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent,
                false
        ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.itemData.text = data[position]
    }
}