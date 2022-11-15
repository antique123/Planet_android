package com.sesac.planet.data.model

import androidx.annotation.Keep

@Keep
data class AuthCodeVerifyResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: String
)