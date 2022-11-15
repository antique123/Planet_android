package com.sesac.planet.data.model.plan

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class PostDetailPlanRequest(
    @SerializedName("plan_content") val planContent: String,
    @SerializedName("type") val type: String
)
