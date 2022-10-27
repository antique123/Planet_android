package com.sesac.planet.presentation.view.main.planet_list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.databinding.ActivityPlanetDetailBinding
import com.sesac.planet.presentation.view.main.planet_list.adapter.PlanetDetailAdapter
import com.sesac.planet.presentation.view.main.planet_list.adapter.PlanetListAdapter
import com.sesac.planet.presentation.view.settings.HomeAddToDoDialog
import com.sesac.planet.utility.SystemUtility

class PlanetDetailActivity : AppCompatActivity(), ItemDragListener {
    private val binding by lazy { ActivityPlanetDetailBinding.inflate(layoutInflater) }
    private lateinit var planetDetailAdapter: PlanetDetailAdapter
    private lateinit var itemTouchHelper: ItemTouchHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initialize()

        binding.planetDetailAddPlansBtn.setOnClickListener {
            HomeAddToDoDialog(this).show()
        }
    }

    private fun initialize() {
        SystemUtility.makeFullScreen(window, binding.root)
        SystemUtility.applyWindowInsetsPadding(binding.root)

        initPlanetDetailRecyclerView()
    }

    private fun initPlanetDetailRecyclerView(){
        val items = mutableListOf<String>().apply {
            add("헬스장 알아보러 가기")
            add("스트레칭")
            add("물 하루 2L 마시기")
            add("소식하기")
        }

        planetDetailAdapter = PlanetDetailAdapter(items, this)
        binding.planetDetailDetailsPlanRecyclerView.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        binding.planetDetailDetailsPlanRecyclerView.adapter = planetDetailAdapter

        //수정 시 진행할 수 있는 부분으로 변경 필요
        //버튼 클릭 시 삭제
        planetDetailAdapter.setItemClickListener(object : PlanetDetailAdapter.OnItemClickListener{
            override fun onDeleteClick(v: View, position: Int) {
                items.removeAt(position)
                planetDetailAdapter.notifyItemRemoved(position)
            }
        })

        //드래그 해서 위치 변경
        itemTouchHelper = ItemTouchHelper(ItemTouchHelperCallback(planetDetailAdapter))
        itemTouchHelper.attachToRecyclerView(binding.planetDetailDetailsPlanRecyclerView)
    }

    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
        itemTouchHelper.startDrag(viewHolder)
    }
}