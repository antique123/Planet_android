package com.sesac.planet.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ReportResponse(
    @SerializedName("result") val result: ResultReport
) : BaseResponse()

@Keep
data class ResultReport(
    @SerializedName("completed_five_weeks_ago") val completed_five_weeks_ago: Int,
    @SerializedName("completed_four_weeks_ago") val completed_four_weeks_ago: Int,
    @SerializedName("completed_three_weeks_ago") val completed_three_weeks_ago: Int,
    @SerializedName("completed_two_weeks_ago") val completed_two_weeks_ago: Int,
    @SerializedName("completed_last_weeks_ago") val completed_last_weeks_ago: Int,
    @SerializedName("total_five_weeks_ago") val total_five_weeks_ago: Int,
    @SerializedName("total_four_weeks_ago") val total_four_weeks_ago: Int,
    @SerializedName("total_three_weeks_ago") val total_three_weeks_ago: Int,
    @SerializedName("total_two_weeks_ago") val total_two_weeks_ago: Int,
    @SerializedName("total_last_weeks_ago") val total_last_weeks_ago: Int
)
