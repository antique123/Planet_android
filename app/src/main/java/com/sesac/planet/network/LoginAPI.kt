package com.sesac.planet.network

import com.sesac.planet.data.model.AuthCodeVerifyRequest
import com.sesac.planet.data.model.AuthCodeVerifyResponse
import com.sesac.planet.data.model.KakaoLoginResponse
import com.sesac.planet.data.model.RequestEmailAuthCodeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface LoginAPI {

    @POST("/oauth/create/kakao")
    suspend fun requestKakaoLogin(
        @Body access_token: String
    ): Response<KakaoLoginResponse>

    @POST("/mail")
    suspend fun requestEmailAuthCode(
        @Header("X-ACCESS-TOKEN") token: String,
        @Body email: String
    ): Response<RequestEmailAuthCodeResponse>

    @POST("/mail/auth")
    suspend fun requestAuthCodeVerify(
        @Header("X-ACCESS-TOKEN") token: String,
        @Body request: AuthCodeVerifyRequest
    ): Response<AuthCodeVerifyResponse>
}