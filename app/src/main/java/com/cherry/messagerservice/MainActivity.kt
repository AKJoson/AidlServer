package com.cherry.messagerservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var bound: Boolean = false
    private var mService: Messenger? = null

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            bound = false
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            mService = Messenger(service)
            bound = true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        button1.setOnClickListener {
//            if (bound) {
//                mService?.send(Message().apply {
//                    what = CLIENT_REQUEST
//                    arg1 = 520
//                })
//            }
//        }
    }

    override fun onStart() {
        super.onStart()
//        Intent(this, MessengerService::class.java).also { intent ->
//            bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
//        }
    }

    override fun onStop() {
        super.onStop()
//        if (bound) {
//            unbindService(serviceConnection)
//            bound = false
//        }
    }

}
