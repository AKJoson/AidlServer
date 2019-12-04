package com.cherry.messagerservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

/**
 *  this is server
 */

class AidlService : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.e(
            "AidlService",
            "onCreate() == CurrentThread: ${Thread.currentThread().name}"
        )
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e(
            "AidlService",
            "onStartCommand() == CurrentThread: ${Thread.currentThread().name}"
        )
        return super.onStartCommand(intent, flags, startId)
    }


    private val iMyAidlInterface = object : IMyAidlInterface.Stub() {
        override fun read(): Int {
            Log.e(
                "AidlService",
                "read() == CurrentThread: ${Thread.currentThread().name}"
            )
            return (Math.random() * 10).toInt()
        }

        override fun write(a: Int) {
            Log.e(
                "AidlService",
                "write() == CurrentThread: ${Thread.currentThread().name} + $a"
            )
        }

    }

    // when client invoke
    override fun onUnbind(intent: Intent?): Boolean {
        Log.e(
            "AidlService",
            "onUnbind() == CurrentThread: ${Thread.currentThread().name}"
        )
        return super.onUnbind(intent)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return iMyAidlInterface.asBinder()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(
            "AidlService",
            "onDestory() == CurrentThread: ${Thread.currentThread().name}"
        )
    }
}