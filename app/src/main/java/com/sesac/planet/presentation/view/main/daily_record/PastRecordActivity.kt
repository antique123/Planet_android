package com.sesac.planet.presentation.view.main.daily_record

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.tabs.TabLayoutMediator
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
        SystemUtility.applyWindowInsetsPadding(binding.root)

        initViews()
    }

    private fun initViews() {
        binding.calendar.setOnDateChangedListener { widget, date, selected ->
            if(selected) {
                Toast.makeText(this@PastRecordActivity, "${date.year} ${date.month} ${date.day}", Toast.LENGTH_SHORT).show()
            }
        }
    }

}