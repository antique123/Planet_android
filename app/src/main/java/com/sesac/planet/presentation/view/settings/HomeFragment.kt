package com.sesac.planet.presentation.view.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.databinding.DialogHomeAddToDoBinding
import com.sesac.planet.databinding.FragmentHomeBinding
import com.sesac.planet.presentation.view.settings.adapter.HomeTodayGrowthPlanAdapter

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeTodayGrowthPlanAdapter: HomeTodayGrowthPlanAdapter

    private var isShowMore: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        initHomeTodayGrowthRecyclerView(isShowMore)

        binding.homeShowMoreBtn.setOnClickListener {
            isShowMore = !isShowMore
            initHomeTodayGrowthRecyclerView(isShowMore)
        }

        binding.homeAddToDoBtn.setOnClickListener {
            HomeAddToDoDialog(requireContext()).show()
        }
    }

    private fun initHomeTodayGrowthRecyclerView(isShowMore: Boolean) {
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

        homeTodayGrowthPlanAdapter = HomeTodayGrowthPlanAdapter(items, isShowMore)
        binding.homeAddToDoRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.homeAddToDoRecyclerView.adapter = homeTodayGrowthPlanAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}