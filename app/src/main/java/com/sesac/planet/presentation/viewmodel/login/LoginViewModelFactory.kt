package com.sesac.planet.presentation.viewmodel.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sesac.planet.domain.usecase.RequestEmailCertificationCodeUseCase
import com.sesac.planet.domain.usecase.RequestKakaoLoginUseCase

class LoginViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(RequestEmailCertificationCodeUseCase(), RequestKakaoLoginUseCase()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel from LoginViewModel")
    }
}