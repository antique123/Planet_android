package com.sesac.planet.presentation.view.main.planet_list

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.data.model.planet.RevisePlanetRequest
import com.sesac.planet.databinding.ActivityPlanetDetailModifyBinding
import com.sesac.planet.presentation.view.main.home.OnSelectColorResult
import com.sesac.planet.presentation.view.main.planet_list.adapter.PlanetDetailModifyAdapter
import com.sesac.planet.presentation.viewmodel.main.plan.PatchDetailPlanViewModel
import com.sesac.planet.presentation.viewmodel.main.plan.PatchDetailPlanViewModelFactory
import com.sesac.planet.presentation.viewmodel.main.planet.PlanetDetailViewModel
import com.sesac.planet.presentation.viewmodel.main.planet.PlanetDetailViewModelFactory
import com.sesac.planet.presentation.viewmodel.main.planet.RevisePlanetViewModel
import com.sesac.planet.presentation.viewmodel.main.planet.RevisePlanetViewModelFactory
import com.sesac.planet.utility.SystemUtility

class PlanetDetailModifyActivity : AppCompatActivity(), ItemDragListener, OnSelectColorResult,
    OnGetCreatePlanetPlanResult {
    private val binding by lazy { ActivityPlanetDetailModifyBinding.inflate(layoutInflater) }
    private lateinit var planetDetailModifyAdapter: PlanetDetailModifyAdapter
    private lateinit var itemTouchHelper: ItemTouchHelper

    private var planetName: String = ""
    private var planetIntro: String = ""
    private var originalColor: String = ""
    private var selectedColor: String = ""

    private var keyword: Int = 0

    private val planetDetailViewModel by lazy {
        ViewModelProvider(
            this,
            PlanetDetailViewModelFactory()
        )[PlanetDetailViewModel::class.java]
    }

    private val revisePlanetViewMode by lazy {
        ViewModelProvider(
            this,
            RevisePlanetViewModelFactory()
        )[RevisePlanetViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        SystemUtility.makeFullScreen(window, binding.root)
        SystemUtility.applyWindowInsetsPadding(binding.root)

        setData()

        binding.planetDetailModifyBackImageView.setOnClickListener {
            finish()
        }

        binding.planetDetailModifyPlanetImg.setOnClickListener {
            SelectColorDialog(this).show(supportFragmentManager, "dialog")
        }

        binding.planetDetailModifyFinishBtn.setOnClickListener {
            val planetModifyName: String = binding.planetDetailModifyPlanetNameEdt.text.toString()
            val planetModifyIntro: String =
                binding.planetDetailModifyExplainPlanetTextView.text.toString()
            val color: String = selectedColor

            if (!planetModifyName.isNullOrBlank()) {
                planetName = planetModifyName
            }

            if (!planetModifyIntro.isNullOrBlank()) {
                planetIntro = planetModifyIntro
            }

            if (selectedColor.isNullOrBlank()) {
                selectedColor = originalColor
            }

            Toast.makeText(
                this,
                "${planetName}의 행성은 ${planetIntro}...한 행성이고 $color 색입니다. ",
                Toast.LENGTH_SHORT
            ).show()

            revisePlanetViewMode.revisePlanet(
                "eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxMSwiaWF0IjoxNjY3NjI2OTA1LCJleHAiOjE2NjkwOTgxMzR9.1IgJRf7fl08M0_5DZPff8a5GCH79hpyFtGkGET5ZtgM",
                keyword,
                RevisePlanetRequest(planetName, planetIntro, selectedColor)
            )
        }
    }

    private fun setData() {
        keyword = intent.getIntExtra("keyword", 0)

        initPlanetDetailInfoObservers()
        planetDetailViewModel.getPlanetDetailInfo(
            "eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxMSwiaWF0IjoxNjY3NjI2OTA1LCJleHAiOjE2NjkwOTgxMzR9.1IgJRf7fl08M0_5DZPff8a5GCH79hpyFtGkGET5ZtgM",
            keyword
        )
    }

    private fun initPlanetDetailInfoObservers() {
        planetDetailViewModel.planetDetailData.observe(this) { response ->
            if (response.isSuccessful) {
                response.body()?.result.let { body ->
                    if (body == null) {
                    } else {
                        binding.planetDetailModifyPlanetNameEdt.hint = body.planet_name
                        planetName = body.planet_name

                        binding.planetDetailModifyPlanetImg.backgroundTintList =
                            ColorStateList.valueOf(Color.parseColor(body.color))
                        originalColor = body.color.toString()

                        binding.planetDetailModifyExplainPlanetTextView.hint = body.planet_intro
                        planetIntro = body.planet_intro.toString()

                        binding.planetDetailModifyGrowthLevelTextView.text =
                            "LV.${body.planet_level}"
                        binding.itemPlanetModifyListLevelProgressBar.max = body.plans.size
                        binding.itemPlanetModifyListLevelProgressBar.progress = body.planet_exp
                        binding.itemPlanetModifyListLevelProgressBar.progressTintList =
                            ColorStateList.valueOf(Color.parseColor(body.color))

                        if (!body.plans.isNullOrEmpty()) {
                            binding.planetDetailModifyDetailsPlanTextView.visibility = View.GONE
                            binding.planetDetailModifyDetailsPlanRecyclerView.visibility =
                                View.VISIBLE

                            planetDetailModifyAdapter = PlanetDetailModifyAdapter(body.plans, this)
                            binding.planetDetailModifyDetailsPlanRecyclerView.layoutManager =
                                LinearLayoutManager(
                                    applicationContext,
                                    RecyclerView.VERTICAL,
                                    false
                                )
                            binding.planetDetailModifyDetailsPlanRecyclerView.adapter =
                                planetDetailModifyAdapter
                        } else {
                            binding.planetDetailModifyDetailsPlanTextView.visibility = View.VISIBLE
                            binding.planetDetailModifyDetailsPlanRecyclerView.visibility = View.GONE

                        }

                        //드래그 해서 위치 변경
                        //itemTouchHelper = ItemTouchHelper(ItemTouchHelperCallback(planetDetailModifyAdapter))
                        //itemTouchHelper.attachToRecyclerView(binding.planetDetailModifyDetailsPlanRecyclerView)
                    }
                }
            }
        }
    }

    override fun onSelectColorResult(colorId: String?) {
        //Dialog에서 색 가져옴
        if (colorId != null) {
            binding.planetDetailModifyPlanetImg.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor(colorId))
            binding.planetModifySelectColorTv.visibility = View.GONE
            binding.itemPlanetModifyListLevelProgressBar.progressTintList =
                ColorStateList.valueOf(Color.parseColor(colorId))

            selectedColor = colorId
        }
    }

    override fun onGetCreatePlanetPlanResult(planContent: String?, type: String?) {
        //세부계획 추가 (초기버전 사용 X)
    }

    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
        itemTouchHelper.startDrag(viewHolder)
    }
}