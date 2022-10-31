package com.sesac.planet.data.model

import com.google.gson.annotations.SerializedName

data class ResultTodayGrowthPlans(
    @SerializedName("planet_id") val planet_id: Int,
    @SerializedName("planet_image") val planet_image: String?,
    @SerializedName("plan_content") val plan_content: String,
    @SerializedName("type") val type: Int
)