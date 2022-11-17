package com.sesac.planet.data.model.plan

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.sesac.planet.data.model.BaseResponse

@Keep
data class TodayGrowthPlansResponse(
    @SerializedName("result") val result: List<ResultTodayGrowthPlans>
) : BaseResponse()

@Keep
data class ResultTodayGrowthPlans(
    @SerializedName("planet_id") val planet_id: Int,
    @SerializedName("plan_content") val plan_content: String,
    @SerializedName("type") val type: String,
    @SerializedName("is_completed") val is_completed: Int,
    @SerializedName("detailed_plan_id") val detailed_plan_id: Int,
    @SerializedName("color") val color: String
)
