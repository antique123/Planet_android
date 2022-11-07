package com.sesac.planet.presentation.viewmodel.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sesac.planet.config.PlanetApplication
import com.sesac.planet.data.model.KakaoLoginResponse
import com.sesac.planet.data.repository.AuthRepository
import com.sesac.planet.domain.usecase.RequestEmailCertificationCodeUseCase
import com.sesac.planet.domain.usecase.RequestKakaoLoginUseCase
import com.sesac.planet.network.LoginAPI
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(
    private val requestEmailCertificationCodeUseCase: RequestEmailCertificationCodeUseCase,
    private val requestKakaoLoginUseCase: RequestKakaoLoginUseCase
) : ViewModel() {
    private var _isSuccessRequestCertificationCode = MutableLiveData<Boolean?>()
    val isSuccessRequestCertificationCode get() = _isSuccessRequestCertificationCode

    private var _kakaoLoginResponse = MutableLiveData<Response<KakaoLoginResponse>>()
    val kakaoLoginResponse: LiveData<Response<KakaoLoginResponse>> get() = _kakaoLoginResponse

    init {
        AuthRepository.loginAPI = PlanetApplication.getInstance().create(LoginAPI::class.java)
    }

    fun requestCertificationCode(email: String) {
        viewModelScope.launch {
            _isSuccessRequestCertificationCode.value = requestEmailCertificationCodeUseCase(email)
        }
    }

    fun requestKakaoLogin(accessToken: String) {
        viewModelScope.launch {
            _kakaoLoginResponse.value = requestKakaoLoginUseCase(accessToken)!!
        }
    }
}