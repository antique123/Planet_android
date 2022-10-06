package com.sesac.planet.utility

import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import android.view.WindowManager

class SystemUtility {
    companion object {
        //TO Light status bar
        fun setLightStatusBar(window: Window, color: Int) {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val wic = window.decorView.windowInsetsController
                wic?.setSystemBarsAppearance(APPEARANCE_LIGHT_STATUS_BARS, APPEARANCE_LIGHT_STATUS_BARS)
            } else {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }

            window.statusBarColor = color
        }

        fun setSoftInputMode(window: Window, mode: Int) {
            window.setSoftInputMode(mode)
        }
    }
}