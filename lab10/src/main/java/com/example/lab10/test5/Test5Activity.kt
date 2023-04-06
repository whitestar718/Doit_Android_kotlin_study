package com.example.lab10.test5

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.lab10.databinding.ActivityTest5Binding

class Test5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTest5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            if (it.all{ permission -> permission.value == true}) {
                noti()
            } else {
                Toast.makeText(this, "permission denied...", Toast.LENGTH_SHORT).show()
            }
        }

        binding.button.setOnClickListener {
            // 버전구문에 = 를 빼먹었더니 이도저도 아닌게 되어 버렸다!
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (ContextCompat.checkSelfPermission(
                        this,
                        "android.permission.POST_NOTIFICATIONS"
                ) == PackageManager.PERMISSION_GRANTED) {
                    noti()
                } else {
                    permissionLauncher.launch(
                        arrayOf("android.permission.POST_NOTIFICATIONS")
                    )
                }
            } else {
                noti()
            }
        }

    }

    fun noti() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val builder: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("one", "one channel", NotificationManager.IMPORTANCE_LOW)
            channel.description = "one description"

            manager.createNotificationChannel(channel)
            builder = NotificationCompat.Builder(this, "one")
        } else {
            builder = NotificationCompat.Builder(this)
        }

        builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
        builder.setWhen(System.currentTimeMillis())
        builder.setContentTitle("Title")
        builder.setContentText("TEXT")

        manager.notify(11, builder.build())
    }
}