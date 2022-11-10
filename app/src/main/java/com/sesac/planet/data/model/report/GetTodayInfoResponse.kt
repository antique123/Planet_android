package com.sesac.planet.data.model.report

import com.google.gson.annotations.SerializedName
import com.sesac.planet.data.model.BaseResponse

data class GetTodayInfoResponse(
    @SerializedName("result") val result: ResultTodayInfo
) : BaseResponse()

data class ResultTodayInfo(
    @SerializedName("today_completed_plan_count") val completedCount: Int,
    @SerializedName("today_total_plan_count") val totalPlan: Int
)
