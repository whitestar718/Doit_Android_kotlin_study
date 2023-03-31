package com.example.lab8.test2

import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import com.example.lab8.databinding.ActivityTest2Binding

class Test2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTest2Binding.inflate((layoutInflater))
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Log.d("eun", "button click")
        }
        binding.checkView.setOnCheckedChangeListener(Myhandler())

//        binding.checkView.setOnCheckedChangeListener(object: CompoundButton.OnCheckedChangeListener {
//            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
//                Log.d("eun", "check click2")
//            }
//        })

        // 매개변수 처리를 잘 해줘야 하는 것을 잊지 말자. (안그러면 빨간줄 그어짐)
        binding.checkView.setOnCheckedChangeListener{ p1: CompoundButton?, p2: Boolean ->
            Log.d("eun", "checkcheck!")
        }
    }
}

class Myhandler : CompoundButton.OnCheckedChangeListener {
    override fun onCheckedChanged(p1: CompoundButton?, p2: Boolean) {
        Log.d("eun", "check click... $p1")
    }
}