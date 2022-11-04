package com.sesac.planet.presentation.view.main.planet_list

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.databinding.ActivityPlanetDetailModifyBinding
import com.sesac.planet.presentation.view.main.planet_list.adapter.PlanetDetailAdapter
import com.sesac.planet.presentation.view.main.planet_list.adapter.PlanetDetailModifyAdapter
import com.sesac.planet.utility.SystemUtility

class PlanetDetailModifyActivity : AppCompatActivity(), ItemDragListener {
    private val binding by lazy { ActivityPlanetDetailModifyBinding.inflate(layoutInflater) }
    private lateinit var planetDetailModifyAdapter: PlanetDetailModifyAdapter
    private lateinit var itemTouchHelper: ItemTouchHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initialize()

        binding.planetDetailModifyBackImageView.setOnClickListener {
            finish()
        }

        binding.planetDetailModifyPlanetNameTv.text = intent.getStringExtra("keyword").toString()
        binding.planetDetailModifyImgNameTv.text = "${intent.getStringExtra("keyword").toString()}\n 행성 이미지"
    }

    private fun initialize() {
        SystemUtility.makeFullScreen(window, binding.root)
        SystemUtility.applyWindowInsetsPadding(binding.root)
        initPlanetDetailModifyRecyclerView()
    }

    private fun initPlanetDetailModifyRecyclerView(){
        val items = mutableListOf<String>().apply {
            add("헬스장 알아보러 가기")
            add("스트레칭")
            add("물 하루 2L 마시기")
            add("소식하기")
        }

        planetDetailModifyAdapter = PlanetDetailModifyAdapter(items, this)
        binding.planetDetailModifyDetailsPlanRecyclerView.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        binding.planetDetailModifyDetailsPlanRecyclerView.adapter = planetDetailModifyAdapter

        //수정 시 진행할 수 있는 부분으로 변경 필요
        //버튼 클릭 시 삭제
        planetDetailModifyAdapter.setItemClickListener(object : PlanetDetailModifyAdapter.OnItemClickListener{
            override fun onDeleteClick(v: View, position: Int) {
                items.removeAt(position)
                planetDetailModifyAdapter.notifyItemRemoved(position)
            }
        })

        //드래그 해서 위치 변경
        itemTouchHelper = ItemTouchHelper(ItemTouchHelperCallback(planetDetailModifyAdapter))
        itemTouchHelper.attachToRecyclerView(binding.planetDetailModifyDetailsPlanRecyclerView)
    }

    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
        itemTouchHelper.startDrag(viewHolder)
    }
}