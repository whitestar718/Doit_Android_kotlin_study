package com.example.ch13_activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ch13_activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var datas: MutableList<String>? = null
    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //add................................
        val requestLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
                it.data!!.getStringExtra("result")?.let {ss ->
                    datas?.add(ss)
                    adapter.notifyDataSetChanged()
            }
        }

        binding.mainFab.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            requestLauncher.launch(intent)
        }

        datas = savedInstanceState?.let{
            it.getStringArrayList("datas")?.toMutableList()
            } ?: mutableListOf<String>()
        

        val layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerView.layoutManager=layoutManager
        adapter=MyAdapter(datas)
        binding.mainRecyclerView.adapter=adapter
        binding.mainRecyclerView.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )
    }

    //add...............................
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList("datas", ArrayList(datas))
    }
    
}