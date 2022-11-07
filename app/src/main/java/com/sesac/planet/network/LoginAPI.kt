package com.sesac.planet.network

import com.sesac.planet.data.model.KakaoLoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginAPI {

    @POST("/oauth/create/kakao")
    suspend fun requestKakaoLogin(
        @Body access_token: String
    ): Response<KakaoLoginResponse>
}