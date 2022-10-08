package com.sesac.planet.presentation.view.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sesac.planet.R
import com.sesac.planet.databinding.FragmentPlanForGoalBinding
import com.sesac.planet.presentation.view.settings.adapter.PlanForGoalAdapter

class PlanForGoalFragment : Fragment() {
    private var _binding: FragmentPlanForGoalBinding? = null
    private val binding get() = _binding!!
    private lateinit var planForGoalAdapter: PlanForGoalAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPlanForGoalBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
    }

    private fun initialize() {
        initPlanForGoalRecyclerView()
        initViews()
    }

    private fun initPlanForGoalRecyclerView() {
        val items = mutableListOf<String>().apply {
            add("다이어트")
            add("진로찾기")
            add("책 읽기")
            add("인간관계")
            add("멘탈관리")
            add("취미")
            add("교양지식")
            add("일")
            add("취업")
        }
        planForGoalAdapter = PlanForGoalAdapter(items)
        binding.wantToAchieveRecyclerView.layoutManager = LinearLayoutManager(requireActivity())
        binding.wantToAchieveRecyclerView.adapter = planForGoalAdapter
    }

    private fun initViews() {
        binding.startNextPageButton.setOnClickListener {
            val action = PlanForGoalFragmentDirections.actionPlanForGoalFragmentToPreviewMyPlanningFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}