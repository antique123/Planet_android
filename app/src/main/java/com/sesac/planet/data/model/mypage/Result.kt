package com.sesac.planet.data.model.mypage

import androidx.annotation.Keep

@Keep
data class Result(
    val email: String,
    val profile_url: String,
    val user_name: String
)