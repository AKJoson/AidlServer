package com.cherry.messagerservice

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.os.Process
import android.widget.Toast

/**
 *  a simple case to test Messenger.
 */
class MessengerService : Service() {

    internal class MessengerHandler : Handler() {

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when (msg.what) {
                CLIENT_REQUEST -> Toast.makeText(
                    BaseApplication.application,
                    BaseApplication.application.getString(R.string.server_receive) + Process.myPid(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onBind(intent: Intent?): IBinder? {
        val messenger = Messenger(MessengerHandler())
        return messenger.binder
    }

}