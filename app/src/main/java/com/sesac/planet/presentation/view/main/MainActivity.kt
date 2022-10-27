package com.sesac.planet.presentation.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.sesac.planet.R
import com.sesac.planet.databinding.ActivityMainBinding
import com.sesac.planet.utility.SystemUtility

class MainActivity : AppCompatActivity() {
    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        SystemUtility.makeFullScreen(window, binding.root)
        initBottomNavigationView()
    }

    private fun initBottomNavigationView() {
        supportFragmentManager.findFragmentById(R.id.fragment_container_view)?.findNavController()
            ?.let { navController ->
                binding.homeBottomNavi.setupWithNavController(navController)
            }
    }
}