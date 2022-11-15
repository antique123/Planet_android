package com.sesac.planet.data.model

import androidx.annotation.Keep

@Keep
data class ResultX(
    val journey_id: Int,
    val jwt: String,
    val userIdx: Int
)