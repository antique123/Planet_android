package com.sesac.planet.presentation.view.settings

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sesac.planet.databinding.FragmentPreviewMyPlanningBinding
import com.sesac.planet.presentation.view.settings.adapter.PlanForGoalAdapter
import com.sesac.planet.presentation.view.settings.adapter.PreviewMyFutureLookAdapter
import com.sesac.planet.presentation.view.settings.adapter.PreviewPlanForGoalAdapter

/**
 * An example full-screen fragment that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class PreviewMyPlanningFragment : Fragment() {
    private var _binding: FragmentPreviewMyPlanningBinding? = null
    private val binding get() = _binding!!
    private lateinit var previewMyFutureLookAdapter: PreviewMyFutureLookAdapter
    private lateinit var previewPlanForGoalAdapter: PreviewPlanForGoalAdapter
    private lateinit var activity: MakePlanningActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPreviewMyPlanningBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
    }

    private fun initialize() {
        initViews()
        initPreviewMyFutureLookRecyclerView()
        initPreviewPlanForGoalRecyclerView()
    }

    private fun initPreviewMyFutureLookRecyclerView() {
        val items = mutableListOf<String>().apply {
            add("상냥한")
            add("강한")
            add("몸짱")
            add("날씬한")
            add("편안한")
        }
        previewMyFutureLookAdapter = PreviewMyFutureLookAdapter(items)
        binding.previewMyFutureLookRecyclerView.layoutManager = GridLayoutManager(requireActivity(), 5, GridLayoutManager.VERTICAL, false)
        binding.previewMyFutureLookRecyclerView.adapter = previewMyFutureLookAdapter
    }

    private fun initPreviewPlanForGoalRecyclerView() {
        val items = mutableListOf<String>().apply {
            add("다이어트")
            add("취업")
            add("책 읽기")
            add("인간 관계")
            add("멘탈관리")
            add("취미")
        }
        previewPlanForGoalAdapter = PreviewPlanForGoalAdapter(items)
        binding.previewPlanForGoalRecyclerView.layoutManager = GridLayoutManager(requireActivity(), 3, GridLayoutManager.VERTICAL, false)
        binding.previewPlanForGoalRecyclerView.adapter = previewPlanForGoalAdapter
    }

    private fun initViews() {
        binding.startNextPageButton.setOnClickListener {
            activity.startMainActivity()
        }

        binding.startPrevPageButton.setOnClickListener {
            val action = PreviewMyPlanningFragmentDirections.actionPreviewMyPlanningFragmentToPlanForGoalFragment()
            findNavController().navigate(action)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (context as? MakePlanningActivity)?.let {
            activity = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}