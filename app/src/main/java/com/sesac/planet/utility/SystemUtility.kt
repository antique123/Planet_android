package com.sesac.planet.utility

import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.updatePadding

class SystemUtility {
    companion object {
        fun setSoftInputMode(window: Window, mode: Int) {
            window.setSoftInputMode(mode)
        }

        fun applyWindowInsetsPadding(view: View, top: Int = 0, bottom: Int = 0, left: Int = 0, right: Int = 0) {
            ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
                v.updatePadding(
                    top = insets.systemWindowInsets.top + top,
                    bottom = insets.systemWindowInsets.bottom + bottom,
                    left = insets.systemWindowInsets.left + left,
                    right = insets.systemWindowInsets.right + right
                )
                insets
            }
        }

        fun applyWindowInsetsTopPadding(view: View, top: Int = 0) {
            ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
                v.updatePadding(
                    top = insets.systemWindowInsets.top + top
                )
                insets
            }
        }

        fun applyWindowInsetsBottomPadding(view: View, bottom: Int = 0) {
            ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
                v.updatePadding(
                    top = insets.systemWindowInsets.bottom + bottom
                )
                insets
            }
        }

        fun makeFullScreen(window: Window, view: View) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                WindowCompat.setDecorFitsSystemWindows(window, false)
            } else {
                view.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            }
        }
    }
}