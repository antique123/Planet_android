package com.sesac.planet.data.model

data class KakaoLoginResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: LoginResult
)

data class LoginResult(
    val jwt: String,
    val user_id: Int
)