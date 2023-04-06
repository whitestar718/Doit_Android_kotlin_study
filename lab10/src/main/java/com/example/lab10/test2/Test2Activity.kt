package com.example.lab10.test2

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.lab10.databinding.ActivityTest2Binding

class Test2Activity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.R) // 내가 알아서 할게 라는 뜻. (하위호환성 무시)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTest2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val toast = Toast.makeText(
                this, "종료하려면 한 번 더 누르세요..",
                Toast.LENGTH_SHORT
            )

            toast.addCallback(
                    object : Toast.Callback() {
                        override fun onToastHidden(){
                            super.onToastHidden()
                            Log.d("eun", "toast hidden")
                        }

                        override fun onToastShown() {
                            super.onToastShown()
                            Log.d("eun", "toast show..")
                        }
                    }
            )
            toast.show()
        }

        binding.button2.setOnClickListener {
            DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(
                    view: DatePicker?,
                    year: Int,
                    month: Int,
                    dayOfMonth: Int
                ) {
                    Log.d("eun", " date: $year $month $dayOfMonth")
                }
            }, 2022, 10, 3).show()
        }

        binding.button3.setOnClickListener {
            TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    Log.d("eun", "time: $hourOfDay, $minute")
                }
            },15, 0, true).show()
        }
    }
}