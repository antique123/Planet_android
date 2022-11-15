package com.sesac.planet.data.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CheckNickNameResponse(
    @SerializedName("code")
    var code: Int?,
    @SerializedName("isSuccess")
    var isSuccess: Boolean?,
    @SerializedName("message")
    var message: String?
)