package com.sesac.planet.presentation.view.main.daily_record

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sesac.planet.databinding.FragmentDailyRecordBinding

class DailyRecordFragment : Fragment() {
    private var _binding : FragmentDailyRecordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDailyRecordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
    }

    private fun initialize() {
        binding.pastRecordButton.setOnClickListener {
            findNavController().navigate(DailyRecordFragmentDirections.actionDailyRecordFragmentToPastRecordActivity())
        }
        binding.writeDailyRecordButton.setOnClickListener {
            findNavController().navigate(DailyRecordFragmentDirections.actionDailyRecordFragmentToWriteDailyRecordActivity())
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}