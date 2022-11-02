package com.sesac.planet.presentation.view.login

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.sesac.planet.databinding.ActivityLoginBinding
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


}