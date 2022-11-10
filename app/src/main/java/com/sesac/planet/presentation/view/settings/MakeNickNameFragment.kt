package com.sesac.planet.presentation.view.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sesac.planet.databinding.FragmentMakeNickNameBinding
import com.sesac.planet.presentation.viewmodel.SettingsViewModel
import com.sesac.planet.presentation.viewmodel.settings.SettingsViewModelFactory
import com.sesac.planet.utility.SystemUtility


class MakeNickNameFragment : Fragment() {
    private var _binding: FragmentMakeNickNameBinding? = null
    private val binding get() = _binding!!
    private val viewModel by lazy { ViewModelProvider(requireActivity(), SettingsViewModelFactory()).get(SettingsViewModel::class.java)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMakeNickNameBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
    }

    private fun initialize() {
        SystemUtility.setSoftInputMode(requireActivity().window, WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        initViews()
    }

    private fun initViews() {
        binding.startNextPageButton.setOnClickListener {
            viewModel.nickName = binding.nickNameEditText.text.toString()
            val action = MakeNickNameFragmentDirections.actionMakeNickNameFragment2ToMyFutureLookFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}