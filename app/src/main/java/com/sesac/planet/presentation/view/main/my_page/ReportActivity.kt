package com.sesac.planet.presentation.view.main.my_page

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sesac.planet.databinding.ActivityReportBinding
import com.sesac.planet.utility.SystemUtility

class ReportActivity : AppCompatActivity() {
    private val binding by lazy { ActivityReportBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initialize()

        binding.reportBackImageView.setOnClickListener {
            finish()
        }
    }

    private fun initialize() {
        SystemUtility.makeFullScreen(window, binding.root)
        SystemUtility.applyWindowInsetsPadding(binding.root)
    }
}