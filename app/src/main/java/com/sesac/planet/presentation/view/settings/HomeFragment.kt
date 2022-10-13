package com.sesac.planet.presentation.view.settings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.databinding.FragmentHomeBinding
import com.sesac.planet.presentation.view.settings.adapter.TodayPlanAdapter

class HomeFragment : Fragment()  {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var todayPlanAdapter: TodayPlanAdapter

    private var isTodayPlan : Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()

        binding.todayPlanSeeButton.setOnClickListener {
            isTodayPlan = !isTodayPlan
            initTodayPlanRecyclerView()
        }
    }

    private fun initialize(){
        initTodayPlanRecyclerView()
    }

    private fun initTodayPlanRecyclerView(){
        val items = mutableListOf<String>().apply {
            add("포폴만들기")
            add("채용정보 확인하기")
            add("인스파이어드 한 섹션 읽기")
            add("인프런 강의듣기")
            add("명상하기")
            add("연합동아리 모임")
            add("산책시키며 걷기")
            add("친구 만나기")
            add("물 하루 2L 마시기")
        }

        todayPlanAdapter = TodayPlanAdapter(items, isTodayPlan)
        binding.todayPlanRecyclerView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.todayPlanRecyclerView.adapter = todayPlanAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}