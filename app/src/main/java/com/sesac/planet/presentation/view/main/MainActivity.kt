package com.sesac.planet.presentation.view.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.sesac.planet.R
import com.sesac.planet.databinding.ActivityMainBinding
import com.sesac.planet.presentation.view.settings.DailyRecordFragment
import com.sesac.planet.presentation.view.settings.HomeFragment
import com.sesac.planet.presentation.view.settings.MyPageFragment
import com.sesac.planet.presentation.view.settings.PlanetListFragment
import com.sesac.planet.utility.SystemUtility

class MainActivity : AppCompatActivity() {
    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initialize()
        navigationItemSelect()
    }

    private fun initialize() {
        SystemUtility.setLightStatusBar(window, Color.WHITE)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frame_container, fragment)
            .commit()
    }

    private fun navigationItemSelect() {
        binding.mainBottomNavi.run {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.action_home -> replaceFragment(HomeFragment())
                    R.id.action_planet_list -> replaceFragment(PlanetListFragment())
                    R.id.action_daily_record -> replaceFragment(DailyRecordFragment())
                    R.id.action_my_page -> replaceFragment(MyPageFragment())
                }
                true
            }
            selectedItemId = R.id.action_home
        }
    }
}