package com.sesac.planet.presentation.view.settings

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sesac.planet.databinding.ActivityMakeNickNameBinding
import com.sesac.planet.utility.SystemUtility

class MakeNickNameActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMakeNickNameBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        SystemUtility.setLightStatusBar(window, Color.WHITE)
        initViews()
    }

    private fun initViews() {
        binding.checkThisNickNameButton.setOnClickListener {
            startActivity(Intent(this, MakePlanningActivity::class.java))
        }
    }
}