package com.sesac.planet.data.model.plan

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.sesac.planet.data.model.BaseResponse

@Keep
data class PostDetailPlanRequest(
    @SerializedName("plan_content") val planContent: String,
    @SerializedName("type") val type: String
)

@Keep
data class PostDetailPlanResponse(
    @SerializedName("result") val result: PostDetailPlanResult
): BaseResponse()

@Keep
data class PostDetailPlanResult(
    @SerializedName("detailed_plan_id") val detailed_plan_id: Int,
    @SerializedName("plan_content") val plan_content: String,
    @SerializedName("planet_id") val planet_id: Int,
    @SerializedName("type") val type: String
)
