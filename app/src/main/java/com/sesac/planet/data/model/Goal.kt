package com.sesac.planet.data.model

data class Goal(
    val field: String = "",
    val details: MutableList<String> = mutableListOf()
)