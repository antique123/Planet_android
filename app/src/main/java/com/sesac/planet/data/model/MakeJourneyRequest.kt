package com.sesac.planet.data.model

data class MakeJourneyRequest(
    val keywords: List<String>,
    val period: Int,
    val nickname
    : String,
    val planets: List<Planet>
)

data class Planet(
    val detailed_plans: List<String>,
    val planet_name: String
)