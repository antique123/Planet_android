package com.sesac.planet.presentation.view.main.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.R
import com.sesac.planet.data.model.TodayGrowthPlanData
import com.sesac.planet.databinding.FragmentHomeBinding
import com.sesac.planet.presentation.view.main.home.adapter.HomeScheduleAdapter
import com.sesac.planet.presentation.view.main.home.adapter.HomeTodayGrowthPlanAdapter
import com.sesac.planet.presentation.view.settings.HomeAddToDoDialog
import com.sesac.planet.presentation.viewmodel.main.PlanViewModel
import com.sesac.planet.utility.SystemUtility

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PlanViewModel
    private lateinit var homeTodayGrowthPlanAdapter: HomeTodayGrowthPlanAdapter
    private lateinit var homeScheduleAdapter: HomeScheduleAdapter

    private var isShowMore: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        Log.d("homefragementtest", "inflate")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        binding.addTodayScheduleBtn.setOnClickListener {
        }
    }

    private fun initViews() {
        initialize()
    }

    private fun initialize() {
        SystemUtility.applyWindowInsetsTopPadding(binding.root)

        //뷰모델 초기화
        //viewModel = ViewModelProvider(this)[PlanViewModel::class.java]

        //기본적인 성장 계획 리사이클러뷰로 보여주기
        initHomeTodayGrowthRcv(isShowMore)
        initHomeScheduleRcv()

        //계획 미리보기, 더보기 버튼 눌렀을 때
        binding.homeShowMoreLayout.setOnClickListener {
            isShowMore = !isShowMore
            initHomeTodayGrowthRcv(isShowMore)

            if(isShowMore){
                binding.homeShowMoreBtn.setImageResource(R.drawable.ic_up_arrow)
            } else{
                binding.homeShowMoreBtn.setImageResource(R.drawable.ic_down_arrow)
            }
        }

        binding.homeAddToDoBtn.setOnClickListener {
            HomeAddToDoDialog(requireContext()).show()
        }
    }

    private fun initHomeTodayGrowthRcv(isShowMore: Boolean) {
        val items = arrayListOf(
            TodayGrowthPlanData(R.drawable.ic_planet_purple, "포폴만들기"),
            TodayGrowthPlanData(R.drawable.ic_planet_basic, "채용정보 확인하기"),
            TodayGrowthPlanData(R.drawable.ic_planet_yellow, "인스파이어드 한 섹션 읽기"),
            TodayGrowthPlanData(R.drawable.ic_planet_yellow, "인프런 강의듣기"),
            TodayGrowthPlanData(R.drawable.ic_planet_navy, "명상하기"),
            TodayGrowthPlanData(R.drawable.ic_planet_basic, "연합동아리 모임"),
            TodayGrowthPlanData(R.drawable.ic_planet_basic, "산책시키며 걷기"),
            TodayGrowthPlanData(R.drawable.ic_planet_basic, "친구 만나기"),
            TodayGrowthPlanData(R.drawable.ic_planet_basic, "물 하루 2L 마시기")
        )

        homeTodayGrowthPlanAdapter = HomeTodayGrowthPlanAdapter(items, isShowMore)
        binding.homeAddToDoRcv.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.homeAddToDoRcv.adapter = homeTodayGrowthPlanAdapter


        /*
        viewModel.data.observe(viewLifecycleOwner, Observer {
            homeTodayGrowthPlanAdapter = HomeTodayGrowthPlanAdapter(it, isShowMore)
        })

        viewModel.setData()
        */

    }

    private fun initHomeScheduleRcv() {
        val items = mutableListOf<String>().apply {
            add("단짝친구 만나기")
            add("동아리 모임")
            add("은행가기")
        }

        homeScheduleAdapter = HomeScheduleAdapter(items)
        binding.homeScheduleRcv.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.homeScheduleRcv.adapter = homeScheduleAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}