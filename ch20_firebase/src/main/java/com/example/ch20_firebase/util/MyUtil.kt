package com.example.ch20_firebase.util

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.text.SimpleDateFormat
import java.util.*


fun myCheckPermission(activity: AppCompatActivity) {
    
    val requestPermissionLauncher = activity.registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            Toast.makeText(activity, "권한 승인", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(activity, "권한 거부", Toast.LENGTH_SHORT).show()
        }
    }
    
    if (ContextCompat.checkSelfPermission(
            activity,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) !== PackageManager.PERMISSION_GRANTED
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Log.d("checkpermission", "launched after tiramisu")
            requestPermissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES)
        } else {
            Log.d("checkpermission", "launched under tiramisu")
            requestPermissionLauncher.launch("android.permission.READ_EXTERNAL_STORAGE")
        }

    } else {
        Log.d("checkpermission", "not executed...")
    }
}

fun dateToString(date: Date): String {
    val format = SimpleDateFormat("yyyy-MM-dd")
    return format.format(date)
}