package com.sesac.planet.data.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CreatePlanetResponse(
    @SerializedName("code")
    var code: Int?,
    @SerializedName("isSuccess")
    var isSuccess: Boolean?,
    @SerializedName("message")
    var message: String?,
    @SerializedName("result")
    var result: ResultXXXX?
)

@Keep
data class ResultXXXX(
    @SerializedName("color")
    var color: String?,
    @SerializedName("planet_id")
    var planetId: Int?,
    @SerializedName("planet_intro")
    var planetIntro: String?,
    @SerializedName("planet_name")
    var planetName: String?
)