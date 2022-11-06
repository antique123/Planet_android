package com.sesac.planet.presentation.viewmodel.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sesac.planet.domain.usecase.RequestEmailCertificationCodeUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    private val requestEmailCertificationCodeUseCase: RequestEmailCertificationCodeUseCase
) : ViewModel() {
    private var _isSuccessRequestCertificationCode = MutableLiveData<Boolean?>()
    val isSuccessRequestCertificationCode get() = _isSuccessRequestCertificationCode

    fun requestCertificationCode(email: String) {
        viewModelScope.launch {
            _isSuccessRequestCertificationCode.value = requestEmailCertificationCodeUseCase(email)
        }
    }

}