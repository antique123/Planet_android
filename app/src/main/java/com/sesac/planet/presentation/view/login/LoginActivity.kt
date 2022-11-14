package com.sesac.planet.presentation.view.login

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.sesac.planet.config.PlanetApplication
import com.sesac.planet.databinding.ActivityLoginBinding
import com.sesac.planet.presentation.view.main.MainActivity
import com.sesac.planet.presentation.view.settings.MakePlanningActivity
import com.sesac.planet.utility.Constant
import com.sesac.planet.utility.SystemUtility

/*
*   TODO: 로그인 하지 않은 사용자 -> 이메일 회원가입 or 카카오로 로그인 or 네이버로 로그인 출력
*         로그인 한 사용자 -> MainActivity or SettingsActivity 로 이동
* */
class LoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        SystemUtility.setSoftInputMode(window, WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }

    fun startNextPage() {
        startActivity(Intent(this, MakePlanningActivity::class.java))
        finish()
    }

    fun startMainPage() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }


    fun restart() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    override fun onStart() {
        super.onStart()
        /*
        if(PlanetApplication.isLoginUser()) {
            startMainPage()
        }

         */

        val userId = PlanetApplication.sharedPreferences.getInt(Constant.USER_ID, -1)
        val jwt = PlanetApplication.sharedPreferences.getString(Constant.X_ACCESS_TOKEN, "")
        val journeyId = PlanetApplication.sharedPreferences.getInt(Constant.JOURNEY_ID, -1)

        jwt?.let { token ->
            if(userId != -1 &&  token.isNotEmpty()) {
                if(journeyId != -1) {
                    startMainPage()
                }
            }
        }
    }

}