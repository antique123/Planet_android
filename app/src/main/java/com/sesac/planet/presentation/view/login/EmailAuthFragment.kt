package com.sesac.planet.presentation.view.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sesac.planet.R
import com.sesac.planet.databinding.FragmentEmailAuthBinding
import com.sesac.planet.presentation.viewmodel.login.LoginViewModel
import com.sesac.planet.presentation.viewmodel.login.LoginViewModelFactory
import com.sesac.planet.utility.SystemUtility

class EmailAuthFragment : Fragment() {
    private var _binding: FragmentEmailAuthBinding? = null
    private val binding get() = _binding!!
    private val viewModel by lazy { ViewModelProvider(requireActivity(), LoginViewModelFactory()).get(LoginViewModel::class.java)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmailAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
    }

    private fun initialize() {
        SystemUtility.setSoftInputMode(requireActivity().window, WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        initViews()
        initObservers()
    }

    private fun initViews() {
        binding.startNextPageButton.setOnClickListener {
            val action = EmailAuthFragmentDirections.actionEmailCertifyFragmentToSetPasswordFragment()
            findNavController().navigate(action)
        }

        binding.inputEmailEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                binding.requestAuthEmailButton.visibility = View.GONE
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.inputEmailEditText.text.isNotEmpty()) {
                    binding.requestAuthEmailButton.visibility = View.VISIBLE
                } else {
                    binding.requestAuthEmailButton.visibility = View.GONE
                }
            }
            override fun afterTextChanged(editable: Editable) {}
        })

        binding.verifyAuthCodeInputEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.verifyAuthCodeInputEditText.text.isNotEmpty()) {
                    binding.verifyAuthCodeButton.isClickable = true
                    binding.verifyAuthCodeButton.setBackgroundColor(resources.getColor(R.color.purple_896DF3, null))
                } else {
                    binding.verifyAuthCodeButton.isClickable = false
                    binding.verifyAuthCodeButton.setBackgroundColor(resources.getColor(R.color.gray_D9D9D9, null))
                }
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        binding.requestAuthEmailButton.setOnClickListener {
            binding.authCodeGroup.visibility = View.VISIBLE
        }

        binding.verifyAuthCodeButton.setOnClickListener {
            //서버에 인증코드 전달
            Toast.makeText(requireActivity(), "클릭", Toast.LENGTH_SHORT).show()
       }
    }

    private fun initObservers() {
        viewModel.isSuccessRequestCertificationCode.observe(viewLifecycleOwner) {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}