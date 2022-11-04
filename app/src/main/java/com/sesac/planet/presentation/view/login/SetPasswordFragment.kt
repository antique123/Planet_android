package com.sesac.planet.presentation.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.navigation.fragment.findNavController
import com.sesac.planet.R
import com.sesac.planet.databinding.FragmentSetPasswordBinding
import com.sesac.planet.utility.SystemUtility

class SetPasswordFragment : Fragment() {
    private var _binding: FragmentSetPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSetPasswordBinding.inflate(inflater, container, false)
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
            val action = SetPasswordFragmentDirections.actionSetPasswordFragmentToSMSAuthFragment()
            findNavController().navigate(action)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}