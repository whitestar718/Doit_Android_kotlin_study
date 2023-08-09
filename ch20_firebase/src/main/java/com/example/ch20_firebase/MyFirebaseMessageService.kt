package com.example.ch20_firebase

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessageService : FirebaseMessagingService() {
    override fun onCreate() {
        super.onCreate()
        println("created service ^^")
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("eun", "fcm token... $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.d("eun", "fcm message..... ${message.notification}")
        Log.d("eun", "fcm message..... ${message.data}")
    }
}