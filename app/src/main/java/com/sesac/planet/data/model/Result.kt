package com.sesac.planet.data.model

import androidx.annotation.Keep

@Keep
data class Result(
    val jwt: String,
    val userIdx: Int
)