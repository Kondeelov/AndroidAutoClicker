package com.kondee.androidautoclicker.services

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.view.LayoutInflater
import android.view.WindowManager
import com.kondee.androidautoclicker.R

class MenuService : Service() {

    private var windowManager: WindowManager? = null

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()

        view = LayoutInflater.from(this).inflate(R.layout.layout_floating_menu, null)

        windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    }
}
