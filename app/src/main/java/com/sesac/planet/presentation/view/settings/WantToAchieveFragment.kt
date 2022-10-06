package com.sesac.planet.presentation.view.settings

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.sesac.planet.R
import com.sesac.planet.databinding.FragmentWantToAchieveBinding

class WantToAchieveFragment : Fragment() {
    private var _binding: FragmentWantToAchieveBinding? = null
    private val binding get() = _binding!!

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
        val args: WantToAchieveFragmentArgs by navArgs()
        args.testArgument?.let {
            Log.d("safeargs_test", it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}