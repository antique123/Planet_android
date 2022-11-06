package com.sesac.planet.data.model

import com.google.gson.annotations.SerializedName

data class PlanetInfoResponse(
    @SerializedName("result") val result: List<ResultPlanetInfo>
) : BaseResponse()

data class ResultPlanetInfo(
    @SerializedName("planet_id") val planet_id: Int,
    @SerializedName("planet_name") val planet_name: String,
    @SerializedName("planet_intro") val planet_intro: String?,
    @SerializedName("planet_exp") val planet_exp: Int,
    @SerializedName("planet_level") val planet_level: Int,
    @SerializedName("planet_image") val planet_image: String?
)