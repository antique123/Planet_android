package com.sesac.planet.presentation.view.main.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.data.model.PlanetInfoResponse
import com.sesac.planet.databinding.FragmentHomeBinding
import com.sesac.planet.network.PlanetInfoAPI
import com.sesac.planet.network.RetrofitClient
import com.sesac.planet.presentation.view.main.home.adapter.HomeTodayGrowthPlanAdapter
import com.sesac.planet.presentation.view.settings.HomeAddToDoDialog
import com.sesac.planet.presentation.viewmodel.main.PlanViewModel
import com.sesac.planet.presentation.viewmodel.main.PlanetInfoViewModel
import com.sesac.planet.utility.SystemUtility
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeTodayGrowthPlanAdapter: HomeTodayGrowthPlanAdapter

    private var isShowMore: Boolean = false

    private val viewModel: PlanetInfoViewModel by viewModels()

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

        //기본적인 성장 계획 리사이클러뷰로 보여주기
        initHomeTodayGrowthRecyclerView(isShowMore)

        //계획 미리보기, 더보기 버튼 눌렀을 때
        binding.homeShowMoreBtn.setOnClickListener {
            isShowMore = !isShowMore
            initHomeTodayGrowthRecyclerView(isShowMore)
        }

        binding.homeAddToDoBtn.setOnClickListener {
            HomeAddToDoDialog(requireContext()).show()
        }
    }

    private fun initHomeTodayGrowthRecyclerView(isShowMore: Boolean) {
        viewModel.getPlanets().observe(viewLifecycleOwner, Observer {
            homeTodayGrowthPlanAdapter = HomeTodayGrowthPlanAdapter(it, isShowMore)
            binding.homeAddToDoRecyclerView.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            binding.homeAddToDoRecyclerView.adapter = homeTodayGrowthPlanAdapter

            if (it.size <= 3) binding.homeShowMoreBtn.visibility = View.GONE
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}