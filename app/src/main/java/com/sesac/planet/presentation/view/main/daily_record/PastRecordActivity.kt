package com.sesac.planet.presentation.view.main.daily_record

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.sesac.planet.R
import com.sesac.planet.databinding.ActivityPastRecordBinding
import com.sesac.planet.presentation.view.main.daily_record.adapter.PastRecordAdapter
import com.sesac.planet.utility.SystemUtility

class PastRecordActivity : AppCompatActivity() {
    private val binding by lazy { ActivityPastRecordBinding.inflate(layoutInflater)}
    private val pastRecordAdapter by lazy { PastRecordAdapter(supportFragmentManager, lifecycle)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        SystemUtility.makeFullScreen(window, binding.root)
        SystemUtility.applyWindowInsetsPadding(binding.root)

        initTabs()
    }

    private fun initTabs() {
        binding.fragmentContainerView.adapter = pastRecordAdapter

        TabLayoutMediator(binding.tabs, binding.fragmentContainerView) { tab, position ->
            tab.text = pastRecordAdapter.getCurrentTabTitle(position)
        }.attach()
    }
}