package com.example.lab15.test3

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class MyJobService : JobService() {

    override fun onCreate() {
        super.onCreate()
        Log.d("eun", "JobService... onCreate")
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        val param = params?.extras?.getString("extra_data")
        Log.d("eun", "JobService... StartJob...$param")

        Thread{
            var sum = 0
            for (i in 1..3){
                sum += i
                Thread.sleep(1000)
            }

            Log.d("eun", "JobService... StartJob...sum: $sum")
            jobFinished(params, false)
        }.start()

        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("eun", "JobService... onDestroy")
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d("eun", "JobService... onStopJob")
        return false
    }
}