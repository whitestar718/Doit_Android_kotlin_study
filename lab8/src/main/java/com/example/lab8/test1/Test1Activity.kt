package com.example.lab8.test1

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.example.lab8.R

class Test1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test1)
        }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.d("haechan", "touch down x: ${event.x}, raw x: ${event.rawX}")
            }
            MotionEvent.ACTION_UP -> {
                Log.d("haechan", "touch up")
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when(keyCode) {
            KeyEvent.KEYCODE_BACK -> Log.d("haechan", "backbutton clicked")
            KeyEvent.KEYCODE_VOLUME_UP -> Log.d("haechan", "vollumn up")
            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.d("haechan", "volumn down")
            }
        return super.onKeyDown(keyCode, event)
        }
    }