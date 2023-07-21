package com.example.lab15.test3

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab15.databinding.ActivityTest3Binding

class Test3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTest3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            // 잡스케줄러 선언
            val scheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            val extras = PersistableBundle()
            extras.putString("extra_data", "hello haechan")

            // 빌더 (잡인포) 선언
            val builder = JobInfo.Builder(1, ComponentName(this, MyJobService::class.java))
            builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED) // 와이파이 = unmetered
            builder.setExtras(extras)

            // 스케줄러 실행
            scheduler.schedule(builder.build())
        }
    }
}