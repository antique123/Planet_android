package com.sesac.planet.presentation.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sesac.planet.databinding.ActivitySplashBinding
import com.sesac.planet.presentation.view.settings.MakePlanningActivity
import com.sesac.planet.utility.Constant
import com.sesac.planet.utility.SystemUtility
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySplashBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        SystemUtility.makeFullScreen(window, binding.root)
        makeSplash()
    }

    private fun makeSplash() {
        CoroutineScope(Dispatchers.Main).launch {
            CoroutineScope(Dispatchers.Main).launch {
                delay(Constant.SPLASH_ANIMATION_MILLIS)
                //TODO 로그인 한 사용자일 경우 MainActivity 로 이동하고 로그인 하지 않은 사용자일 경우 LoginActivity 로 이동하도록 수정 필요
                startActivity(Intent(this@SplashActivity, MakePlanningActivity::class.java))
                finish()
            }
        }
    }
}