package com.sesac.planet.presentation.view.main.daily_record

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sesac.planet.R
import com.sesac.planet.databinding.ActivityPastRecordBinding
import com.sesac.planet.utility.SystemUtility

class PastRecordActivity : AppCompatActivity() {
    private val binding by lazy { ActivityPastRecordBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        SystemUtility.makeFullScreen(window, binding.root)
    }
}