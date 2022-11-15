package com.sesac.planet.data.model

import androidx.annotation.Keep

@Keep
data class MakeJourneyResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: MakeJourneyResult
)

@Keep
data class MakeJourneyResult(
    val journey_id: Int,
    val keywords: List<String>,
    val nickname: String,
    val period: Int,
    val planets: List<Planet>,
    val user_id: Int
)
