package com.sesac.planet.presentation.view.main.planet_list

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.data.model.plan.CreatePlanetPlanData
import com.sesac.planet.databinding.ActivityCreatePlanetBinding
import com.sesac.planet.presentation.view.main.home.OnSelectColorResult
import com.sesac.planet.utility.SystemUtility

class CreatePlanetActivity : AppCompatActivity(), OnSelectColorResult, OnGetCreatePlanetPlanResult {
    private val binding by lazy { ActivityCreatePlanetBinding.inflate(layoutInflater) }

    private var planData:MutableList<CreatePlanetPlanData> = mutableListOf()
    private lateinit var createDetailPlanAdapter: CreateDetailPlanAdapter

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

        binding.createDetailNoPlanTitle.visibility = View.VISIBLE
        binding.createDetailPlanRcv.visibility = View.GONE

        binding.planetDetailPlanetImg.setOnClickListener {
            SelectColorDialog(this).show(supportFragmentManager, "Dialog")
        }

        binding.planetDetailAddPlansBtn.setOnClickListener {
            CreatePlanetPlanDialog(this).show(supportFragmentManager, "CreatePlanetPlanDialog")
        }
    }

    //Dialog에서 선택한 색깔 값 받아옴
    override fun onSelectColorResult(colorId: String?) {
        if (colorId != null) {
            binding.planetDetailPlanetImg.backgroundTintList = ColorStateList.valueOf(Color.parseColor(colorId))
            binding.createPlanetSelectColorTv.visibility = View.GONE
        }
    }

    //Dialog에서 작성한 계획과 타입 받아옴
    override fun onGetCreatePlanetPlanResult(planContent: String?, type: String?) {
        if(planContent != null && type != null){
            binding.createDetailNoPlanTitle.visibility = View.GONE
            binding.createDetailPlanRcv.visibility = View.VISIBLE

            planData.add(CreatePlanetPlanData(planContent, type))

            createDetailPlanAdapter = CreateDetailPlanAdapter(planData)
            binding.createDetailPlanRcv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            binding.createDetailPlanRcv.adapter = createDetailPlanAdapter
        }
    }
}