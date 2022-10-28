package com.sesac.planet.presentation.view.settings

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sesac.planet.R
import com.sesac.planet.databinding.ActivityMakePlanningBinding
import com.sesac.planet.presentation.view.main.MainActivity
import com.sesac.planet.utility.SystemUtility

class MakePlanningActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMakePlanningBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        SystemUtility.makeFullScreen(window, binding.root)
        SystemUtility.applyWindowInsetsPadding(binding.root)
    }

    fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}