package com.sesac.planet.domain.usecase

import com.sesac.planet.data.model.KakaoLoginResponse
import com.sesac.planet.data.repository.AuthRepository
import retrofit2.Response

class RequestKakaoLoginUseCase {
    suspend operator fun invoke(accessToken: String) = AuthRepository.requestKakaoLogin(accessToken)
}