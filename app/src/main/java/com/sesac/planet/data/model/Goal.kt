package com.sesac.planet.data.model

import androidx.annotation.Keep

@Keep
data class Goal(
    val field: String = "",
    val details: MutableList<String> = mutableListOf()
)