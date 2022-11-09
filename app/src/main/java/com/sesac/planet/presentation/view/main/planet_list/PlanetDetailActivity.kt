package com.sesac.planet.presentation.view.main.planet_list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.databinding.ActivityPlanetDetailBinding
import com.sesac.planet.presentation.view.main.planet_list.adapter.PlanetDetailAdapter
import com.sesac.planet.presentation.viewmodel.main.*
import com.sesac.planet.utility.SystemUtility

class PlanetDetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityPlanetDetailBinding.inflate(layoutInflater) }
    private lateinit var planetDetailAdapter: PlanetDetailAdapter

    private val planetDetailViewModel by lazy {
        ViewModelProvider(
            this,
            PlanetDetailViewModelFactory()
        )[PlanetDetailViewModel::class.java]
    }

    private var keyword: Int= 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initialize()
        initView()
    }

    private fun initialize() {
        SystemUtility.makeFullScreen(window, binding.root)
        SystemUtility.applyWindowInsetsPadding(binding.root)

        setData()
    }

    private fun initView(){
        binding.planetDetailAddPlansBtn.setOnClickListener {
            //HomeAddToDoDialog(this).show()
        }

        binding.planetDetailBackImageView.setOnClickListener{
            finish()
        }

        binding.planetDetailModifyBtn.setOnClickListener {
            val intent = Intent(this, PlanetDetailModifyActivity::class.java)
            intent.putExtra("keyword",keyword)
            startActivity(intent)
        }
    }

    private fun setData(){
        keyword = intent.getIntExtra("planet_id",0)
        Log.d("받아온 키 값", keyword.toString())

        initPlanetDetailInfoObservers()
        planetDetailViewModel.getPlanetDetailInfo(
            "eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NjY1OTQwOTcsImV4cCI6MTY2ODA2NTMyNn0.Ro1EyIxo44NIi1Jos7ssbCvkDdlSWhYPIBaMfabY7QQ",
            keyword
        )
    }

    private fun initPlanetDetailInfoObservers(){
        planetDetailViewModel.planetDetailData.observe(this){ response ->
            if(response.isSuccessful){
                response.body()?.result.let { body ->
                    if(body == null){
                    } else {
                        binding.planetDetailPlanetNameTv.text = body.planet_name
                        binding.planetDetailExplainPlanetTextView.text = body.planet_intro
                        binding.planetDetailGrowthLevelTextView.text = "LV.${body.planet_level}"
                        binding.itemPlanetListLevelProgressBar.progress = body.planet_exp

                        planetDetailAdapter = PlanetDetailAdapter(body.plans)
                        binding.planetDetailDetailsPlanRecyclerView.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
                        binding.planetDetailDetailsPlanRecyclerView.adapter = planetDetailAdapter
                    }
                }
            }
        }
    }

}