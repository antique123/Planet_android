package com.sesac.planet.presentation.view.main.daily_record.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sesac.planet.presentation.view.main.daily_record.DailyFragment
import com.sesac.planet.presentation.view.main.daily_record.MonthlyFragment
import com.sesac.planet.presentation.view.main.daily_record.WeeklyFragment

class PastRecordAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    private val fragments = arrayOf(DailyFragment(), WeeklyFragment(), MonthlyFragment())

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int) = fragments[position]

    fun getCurrentTabTitle(position: Int): String = when(position) {
        0 -> "일별"
        1 -> "주별"
        2 -> "월별"
        else -> ""
    }
}