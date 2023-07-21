package com.example.ch15_outer

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.*

class MyMessengerService : Service() {
    lateinit var messenger: Messenger // activity 데이터 받는 용도
    lateinit var replyMessenger: Messenger // activity에 데이터 전달해주는 용도
    lateinit var player: MediaPlayer

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer()
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release() // 플레이어 리소스 해제
    }

    inner class IncomingHandler(
        context: Context,
        private val applicationContext: Context = context.applicationContext
    ) : Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when(msg.what){

                // 서비스에 연결된 시점
                10 -> {
                    replyMessenger = msg.replyTo
                    if (!player.isPlaying) {
                        player = MediaPlayer.create(this@MyMessengerService, R.raw.music)
                        try {
                            // 데이터 준비
                            val replyMsg = Message()
                            replyMsg.what = 10
                            val replyBundle = Bundle()
                            replyBundle.putInt("duration", player.duration)
                            replyMsg.obj = replyBundle

                            // 데이터 전달
                            replyMessenger.send(replyMsg)

                            player.start()
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }
                
                // 음악 플레이 중지
                20 -> {
                    if (player.isPlaying)
                        player.stop()
                }

                // 기타 처리
                else -> super.handleMessage(msg)
            }
        }
    }

    override fun onBind(intent: Intent): IBinder {
        // 핸들러 객체 등록
        messenger = Messenger(IncomingHandler(this))
        return messenger.binder
    }
}