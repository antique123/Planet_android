package com.sesac.planet.data.repository

import com.sesac.planet.data.model.KakaoLoginResponse
import com.sesac.planet.network.LoginAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

object AuthRepository {
    lateinit var loginAPI: LoginAPI

    suspend fun requestKakaoLogin(accessToken: String) = withContext(Dispatchers.IO) {
        loginAPI.requestKakaoLogin(accessToken)
    }
}