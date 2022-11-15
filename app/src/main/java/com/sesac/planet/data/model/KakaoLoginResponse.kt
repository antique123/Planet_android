package com.sesac.planet.data.model

import androidx.annotation.Keep

@Keep
data class KakaoLoginResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: LoginResult
)

@Keep
data class LoginResult(
    val journey_id: Int,
    val jwt: String,
    val user_id: Int
)