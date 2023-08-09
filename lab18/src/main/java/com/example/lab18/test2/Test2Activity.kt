package com.example.lab18.test2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.lab18.databinding.ActivityTest2Binding
import org.json.JSONObject

class Test2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTest2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val queue = Volley.newRequestQueue(this)
        binding.button.setOnClickListener {
            val request = JsonObjectRequest(
                Request.Method.GET,
                "https://reqres.in/api/users/2",
                null,
                Response.Listener<JSONObject> { response ->
                    val dataJson = response.getJSONObject("data")
                    val id = dataJson.getString("id")
                    val email = dataJson.getString("email")
                    Log.d("eun", "$id, $email")
                },
                Response.ErrorListener { error ->
                    Log.d("eun error", "error...")
                }
            )

            queue.add(request)
        }
    }
}