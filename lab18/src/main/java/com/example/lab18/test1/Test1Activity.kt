package com.example.lab18.test1

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.telephony.*
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.lab18.R

class Test1Activity : AppCompatActivity() {

    lateinit var telephonyManager: TelephonyManager

    private fun callChanged() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            telephonyManager.registerTelephonyCallback(
                mainExecutor,
                object : TelephonyCallback(), TelephonyCallback.CallStateListener {
                    override fun onCallStateChanged(state: Int) {
                        when(state) {
                            TelephonyManager.CALL_STATE_IDLE -> {
                                Log.d("eun", "idle...")
                            }
                            TelephonyManager.CALL_STATE_OFFHOOK -> {
                                Log.d("eun", "offhook")
                            }
                            TelephonyManager.CALL_STATE_RINGING -> {
                                Log.d("eun", "ringing...")
                            }
                        }
                    }
                }
            )
        } else {
            val listener = object: PhoneStateListener(){
                override fun onCallStateChanged(state: Int, phoneNumber: String?) {
                    when (state) {
                        TelephonyManager.CALL_STATE_IDLE -> {
                            Log.d("eun", "idle...")
                        }
                        TelephonyManager.CALL_STATE_OFFHOOK -> {
                            Log.d("eun", "offhook")
                        }
                        TelephonyManager.CALL_STATE_RINGING -> {
                            Log.d("eun", "ringing...")
                        }
                    }
                }
            }
            telephonyManager.listen(listener, PhoneStateListener.LISTEN_CALL_STATE)
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun phoneInfo(){
        val countryIso = telephonyManager.networkCountryIso
        val operatorName = telephonyManager.networkOperatorName
        var phoneNumber = "unknown"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val subscriptionManager = getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE) as SubscriptionManager
            for (subscriptionInfo: SubscriptionInfo in subscriptionManager.activeSubscriptionInfoList) {
                val activeSubscriptionId: Int = subscriptionInfo.subscriptionId
                phoneNumber = subscriptionManager.getPhoneNumber(activeSubscriptionId)
                Log.d("phonenumber: ", "$phoneNumber")
            }
        } else {
            phoneNumber = telephonyManager.line1Number
        }
        Log.d("eun", "$countryIso, $operatorName, $phoneNumber")
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test1)

        telephonyManager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager

        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            if (it.all { permission -> permission.value }) {
                callChanged()
                phoneInfo()
            } else {
                Toast.makeText(this, "permission denied..", Toast.LENGTH_SHORT).show()
            }
        }

        // permission check
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_PHONE_NUMBERS") ==
                    PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this, "android.permission.READ_PHONE_STATE") ==
                    PackageManager.PERMISSION_GRANTED) {
            callChanged()
            phoneInfo()
        } else {
            permissionLauncher.launch(arrayOf(
                "android.permission.READ_PHONE_NUMBERS",
                "android.permission.READ_PHONE_STATE"
            ))
        }
    }
}