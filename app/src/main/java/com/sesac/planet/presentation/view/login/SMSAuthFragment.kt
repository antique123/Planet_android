package com.sesac.planet.presentation.view.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.sesac.planet.R
import com.sesac.planet.databinding.FragmentSMSAuthBinding
import com.sesac.planet.presentation.view.settings.MakePlanningActivity
import com.sesac.planet.utility.SystemUtility


class SMSAuthFragment : Fragment() {
    private var _binding: FragmentSMSAuthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSMSAuthBinding.inflate(inflater, container, false)
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
            // TODO: 회원가입 과정이 끝났으므로 로그인 화면으로 다시 이동하도록 변경 필요
            startActivity(Intent(requireActivity(), MakePlanningActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}