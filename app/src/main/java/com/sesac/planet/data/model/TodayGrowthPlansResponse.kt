package com.sesac.planet.data.model

import com.google.gson.annotations.SerializedName

data class TodayGrowthPlansResponse(
    @SerializedName("result") val result: List<ResultTodayGrowthPlans>
) : BaseResponse()
