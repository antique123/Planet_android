package com.sesac.planet.presentation.view.settings

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sesac.planet.data.model.Goal
import com.sesac.planet.databinding.FragmentPlanForGoalBinding
import com.sesac.planet.presentation.view.settings.adapter.PlanForGoalAdapter
import com.sesac.planet.presentation.viewmodel.SettingsViewModel
import com.sesac.planet.presentation.viewmodel.settings.SettingsViewModelFactory

class PlanForGoalFragment : Fragment() {
    private var _binding: FragmentPlanForGoalBinding? = null
    private val binding get() = _binding!!
    private val viewModel by lazy { ViewModelProvider(requireActivity(), SettingsViewModelFactory()).get(SettingsViewModel::class.java)}
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

        val items = mutableListOf<Goal>()
        items.addAll(viewModel.wantToAchieveItems)


        //val items = mutableListOf<String>()
        //items.addAll(viewModel.wantToAchieveItems)
        planForGoalAdapter = PlanForGoalAdapter(items)
        planForGoalAdapter.addDetails = { key, detail, position ->
            val item = viewModel.wantToAchieveItems.find {
                it.field == key
            }
            val idx = viewModel.wantToAchieveItems.indexOf(item)
            if(viewModel.wantToAchieveItems[idx].details.size <= position) {
                viewModel.wantToAchieveItems[idx].details.add(detail)
            } else {
                viewModel.wantToAchieveItems[idx].details.set(position, detail)
            }
            Log.d("detailTest", "$position ${viewModel.wantToAchieveItems[idx].toString()}")
        }
        binding.wantToAchieveRecyclerView.layoutManager = LinearLayoutManager(requireActivity())
        binding.wantToAchieveRecyclerView.adapter = planForGoalAdapter
    }

    private fun initViews() {
        binding.startNextPageButton.setOnClickListener {
            val action = PlanForGoalFragmentDirections.actionPlanForGoalFragmentToPreviewMyPlanningFragment()
            findNavController().navigate(action)
        }

        binding.startPrevPageButton.setOnClickListener {
            val action = PlanForGoalFragmentDirections.actionPlanForGoalFragmentToWantToAchieveFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}