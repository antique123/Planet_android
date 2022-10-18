package com.sesac.planet.presentation.view.settings

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.databinding.ActivityPlanetDetailBinding
import com.sesac.planet.presentation.view.settings.adapter.PlanDetailAdapter
import com.sesac.planet.utility.SystemUtility

class PlanetDetailActivity : AppCompatActivity() {
    private val binding by lazy {ActivityPlanetDetailBinding.inflate(layoutInflater)}
    private lateinit var planDetailAdapter: PlanDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.planetTitleTextView.text = "${intent.getStringExtra("key")} 행성"
        binding.planetImgTextView.text = "${intent.getStringExtra("key")}\n행성 이미지"

        initialize()
    }

    private fun initialize() {
        SystemUtility.setLightStatusBar(window, Color.WHITE)
        initPlanDetailRecyclerView()
    }

    private fun initPlanDetailRecyclerView() {
        val items = mutableListOf<String>().apply {
            add("헬스장 알아보러가기")
            add("스트레칭")
            add("물 하루 2L 마시기")
            add("소식하기")
            add("헬스장 알아보러가기")
            add("스트레칭")
            add("물 하루 2L 마시기")
            add("소식하기")
        }

        planDetailAdapter = PlanDetailAdapter(items)
        binding.planDetailRecyclerView.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        binding.planDetailRecyclerView.adapter = planDetailAdapter
    }
}