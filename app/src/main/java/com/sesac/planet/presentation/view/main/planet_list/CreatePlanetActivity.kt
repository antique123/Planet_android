package com.sesac.planet.presentation.view.main.planet_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sesac.planet.databinding.ActivityCreatePlanetBinding
import com.sesac.planet.utility.SystemUtility

class CreatePlanetActivity : AppCompatActivity() {
    private val binding by lazy { ActivityCreatePlanetBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initialize()
        initView()
    }

    private fun initialize() {
        SystemUtility.makeFullScreen(window, binding.root)
        SystemUtility.applyWindowInsetsPadding(binding.root)
    }

    private fun initView(){
        binding.createBackImg.setOnClickListener {
            finish()
        }

        binding.planetDetailPlanetImg.setOnClickListener {
            SelectColorDialog().show(supportFragmentManager, "Dialog")
        }

        binding.planetDetailAddPlansBtn.setOnClickListener {
            CreatePlanetPlanDialog().show(supportFragmentManager, "CreatePlanetPlanDialog")
        }
    }
}