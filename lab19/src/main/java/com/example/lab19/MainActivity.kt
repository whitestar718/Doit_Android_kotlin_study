package com.example.lab19

import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    lateinit var manager: LocationManager

    fun getLocation() {
        val location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        location?.let{
            val latitude = location.latitude
            val longitude = location.longitude
            val accuracy = location.accuracy
            Log.d("eun", "$latitude, $longitude, $accuracy")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = getSystemService(LOCATION_SERVICE) as LocationManager
        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ){
            if (it) {
                getLocation()
            } else {
                Toast.makeText(this, "denied...", Toast.LENGTH_SHORT).show()
            }
        }

        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == PackageManager.PERMISSION_GRANTED) {
            getLocation()
        } else {
            permissionLauncher.launch("android.permission.ACCESS_FINE_LOCATION")
        }
    }
}