package com.sesac.planet.presentation.viewmodel.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sesac.planet.config.PlanetApplication
import com.sesac.planet.data.model.AuthCodeVerifyRequest
import com.sesac.planet.data.model.AuthCodeVerifyResponse
import com.sesac.planet.data.model.KakaoLoginResponse
import com.sesac.planet.data.model.RequestEmailAuthCodeResponse
import com.sesac.planet.data.repository.AuthRepository
import com.sesac.planet.domain.usecase.RequestAuthCodeVerifyUseCase
import com.sesac.planet.domain.usecase.RequestEmailCertificationCodeUseCase
import com.sesac.planet.domain.usecase.RequestKakaoLoginUseCase
import com.sesac.planet.network.LoginAPI
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(
    private val requestEmailCertificationCodeUseCase: RequestEmailCertificationCodeUseCase,
    private val requestKakaoLoginUseCase: RequestKakaoLoginUseCase,
    private val requestAuthCodeVerifyUseCase: RequestAuthCodeVerifyUseCase
) : ViewModel() {
    private var _requestAuthCodeResponse: MutableLiveData<Response<RequestEmailAuthCodeResponse>> = MutableLiveData()
    val requestAuthCodeResponse: LiveData<Response<RequestEmailAuthCodeResponse>> get() = _requestAuthCodeResponse

    private var _kakaoLoginResponse = MutableLiveData<Response<KakaoLoginResponse>>()
    val kakaoLoginResponse: LiveData<Response<KakaoLoginResponse>> get() = _kakaoLoginResponse

    private var _requestAuthCodeVerifyResponse: MutableLiveData<Response<AuthCodeVerifyResponse>> = MutableLiveData()
    val requestAuthCodeVerifyResponseResponse: LiveData<Response<AuthCodeVerifyResponse>> get() = _requestAuthCodeVerifyResponse

    init {
        AuthRepository.loginAPI = PlanetApplication.getInstance().create(LoginAPI::class.java)
    }

    fun requestCertificationCode(token: String, email: String) {
        viewModelScope.launch {
            _requestAuthCodeResponse.value = requestEmailCertificationCodeUseCase(token, email)!!
        }
    }

    fun requestKakaoLogin(accessToken: String) {
        viewModelScope.launch {
            _kakaoLoginResponse.value = requestKakaoLoginUseCase(accessToken)!!
        }
    }

    fun requestAuthCodeVerify(token: String, request: AuthCodeVerifyRequest) {
        viewModelScope.launch {
            _requestAuthCodeVerifyResponse.value = requestAuthCodeVerifyUseCase(token ,request)!!
        }
    }
}