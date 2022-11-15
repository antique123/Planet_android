package com.sesac.planet.data.model

import androidx.annotation.Keep

@Keep
data class AuthCodeVerifyRequest(
    val auth: String,
    val email: String
)