package com.sesac.planet.data.repository

import com.sesac.planet.data.model.AuthCodeVerifyRequest
import com.sesac.planet.data.model.AuthCodeVerifyResponse
import com.sesac.planet.data.model.KakaoLoginResponse
import com.sesac.planet.data.model.RequestEmailAuthCodeResponse
import com.sesac.planet.network.LoginAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

object AuthRepository {
    lateinit var loginAPI: LoginAPI

    suspend fun requestKakaoLogin(accessToken: String) = withContext(Dispatchers.IO) {
        loginAPI.requestKakaoLogin(accessToken)
    }

    suspend fun requestEmailAuthCode(token: String, email: String): Response<RequestEmailAuthCodeResponse> {
        val response: Response<RequestEmailAuthCodeResponse>
        withContext(Dispatchers.IO) {
            response = loginAPI.requestEmailAuthCode(token, email)
        }
        return response
    }

    suspend fun requestAuthCodeVerify(token: String, request: AuthCodeVerifyRequest): Response<AuthCodeVerifyResponse> {
        val response: Response<AuthCodeVerifyResponse>
        withContext(Dispatchers.IO) {
            response = loginAPI.requestAuthCodeVerify(token, request)
        }
        return response
    }

}