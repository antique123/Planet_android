package com.sesac.planet.data.model

import androidx.annotation.Keep

@Keep
data class EmailSignInRequest(
    val email: String,
    val password: String
)