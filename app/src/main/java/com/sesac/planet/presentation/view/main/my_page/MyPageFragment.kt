package com.sesac.planet.presentation.view.main.my_page

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.kakao.sdk.user.UserApiClient
import com.sesac.planet.config.PlanetApplication
import com.sesac.planet.databinding.FragmentMyPageBinding
import com.sesac.planet.utility.Constant
import com.sesac.planet.utility.SystemUtility

class MyPageFragment : Fragment()  {
    private var _binding : FragmentMyPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SystemUtility.applyWindowInsetsTopPadding(binding.root)
        initialize()
        /*
        binding.myPageReportLayout.setOnClickListener {
            val intent = Intent(requireContext(), ReportActivity::class.java)
            startActivity(intent)
        }

         */


    }

    private fun initialize() {
        initViews()
    }

    private fun initViews() {
        binding.myPageLogoutBtn.setOnClickListener {
            if(PlanetApplication.isLoginUser()) {
                when (PlanetApplication.getLoginType()) {
                    Constant.KAKAO_LOGIN -> {
                        UserApiClient.instance.logout {
                            PlanetApplication.sharedPreferences.edit {
                                putString(Constant.X_ACCESS_TOKEN, null)
                                putInt(Constant.USER_ID, -1)
                                putInt(Constant.LOGIN_TYPE, -1)
                                Snackbar.make(binding.root, "로그아웃에 성공했습니다.", Snackbar.LENGTH_SHORT).show()

                            }
                        }
                    }
                    Constant.EMAIL_LOGIN -> {

                    }
                    else -> {

                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}