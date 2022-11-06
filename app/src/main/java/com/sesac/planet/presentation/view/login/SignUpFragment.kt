package com.sesac.planet.presentation.view.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.KakaoSdkError
import com.kakao.sdk.user.UserApiClient
import com.sesac.planet.R
import com.sesac.planet.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private val callback: (token: OAuthToken?, error: Throwable?) -> Unit = { token, error ->
        if(error != null) {
            Log.d("KakaoLogin", "로그인 실패 $error")
        } else if(token != null) {
            Log.d("access_token", token.accessToken)
            //서버 요청
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
    }

    private fun initialize() {
        initViews()
    }

    private fun initViews() {
        binding.emailSignUpButton.setOnClickListener {
            val action = SignUpFragmentDirections.actionSignUpFragmentToEmailCertifyFragment()
            findNavController().navigate(action)
        }

        binding.kakaoLoginButton.setOnClickListener {
            if(UserApiClient.instance.isKakaoTalkLoginAvailable(requireActivity())) {
                Log.d("KakaoLoginTest", "loginWithKakaoTalk")
                UserApiClient.instance.loginWithKakaoTalk(requireActivity(), callback = callback)
            } else {
                Log.d("KakaoLoginTest", "loginWithKakaoAccount")
                UserApiClient.instance.loginWithKakaoAccount(requireActivity(), callback = callback)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}