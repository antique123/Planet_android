package com.sesac.planet.presentation.view.settings

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.sesac.planet.R
import com.sesac.planet.databinding.FragmentWantToAchieveBinding
import com.sesac.planet.presentation.view.settings.adapter.WantToAchieveAdapter

class WantToAchieveFragment : Fragment() {
    private var _binding: FragmentWantToAchieveBinding? = null
    private val binding get() = _binding!!
    private lateinit var wantToAchieveAdapter: WantToAchieveAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWantToAchieveBinding.inflate(inflater, container ,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
    }

    private fun initialize() {
        initWantToAchieveRecyclerView()
        initViews()
    }

    private fun initWantToAchieveRecyclerView() {
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
            add("not define")
            add("not define")
            add("not define")
            add("not define")
        }
        wantToAchieveAdapter = WantToAchieveAdapter(items)
        binding.wantToAchieveRecyclerView.layoutManager = GridLayoutManager(requireActivity(), 3, GridLayoutManager.VERTICAL, false)
        binding.wantToAchieveRecyclerView.adapter = wantToAchieveAdapter
    }

    private fun initViews() {
        binding.startNextPageButton.setOnClickListener {
            val action = WantToAchieveFragmentDirections.actionWantToAchieveFragmentToPlanForGoalFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}