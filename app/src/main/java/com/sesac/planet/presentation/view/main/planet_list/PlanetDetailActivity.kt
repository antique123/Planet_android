package com.sesac.planet.presentation.view.main.planet_list

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.databinding.ActivityPlanetDetailBinding
import com.sesac.planet.presentation.view.main.planet_list.adapter.PlanetDetailAdapter
import com.sesac.planet.utility.SystemUtility

class PlanetDetailActivity : AppCompatActivity()  {
    private val binding by lazy { ActivityPlanetDetailBinding.inflate(layoutInflater) }
    private lateinit var planetDetailAdapter: PlanetDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        SystemUtility.setLightStatusBar(window, Color.WHITE)
        initPlanetDetailRecyclerView()
    }

    private fun initPlanetDetailRecyclerView(){
        val items = mutableListOf<String>().apply {
            add("헬스장 알아보러 가기")
            add("스트레칭")
            add("물 하루 2L 마시기")
            add("소식하기")
        }

        planetDetailAdapter = PlanetDetailAdapter(items)
        binding.planetDetailDetailsPlanRecyclerView.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        binding.planetDetailDetailsPlanRecyclerView.adapter = planetDetailAdapter
    }
}