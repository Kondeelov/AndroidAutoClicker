package com.kondee.androidautoclicker.services

import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Build
import android.os.IBinder
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import com.kondee.androidautoclicker.R

class MenuService : Service() {

    private var windowManager: WindowManager? = null
    private var layoutParams: WindowManager.LayoutParams? = null

    private var view: View? = null

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()

        view = LayoutInflater.from(this).inflate(R.layout.layout_floating_menu, null)

        val buttonPlayPause: ImageButton? = view?.findViewById(R.id.button_play_pause)
        val buttonAdd: ImageButton? = view?.findViewById(R.id.button_add)
        val buttonClose: ImageButton? = view?.findViewById(R.id.button_close)

        val overlayParam = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        } else {
            WindowManager.LayoutParams.TYPE_PHONE
        }

        layoutParams = WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                overlayParam,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT)

        windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager?.addView(view, layoutParams)

    }

    override fun onDestroy() {
        super.onDestroy()

        windowManager?.removeView(view)
    }
}
