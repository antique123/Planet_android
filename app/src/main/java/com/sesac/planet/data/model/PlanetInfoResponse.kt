package com.sesac.planet.data.model

import com.google.gson.annotations.SerializedName

data class PlanetInfoResponse(
    @SerializedName("result") val result: List<ResultPlanetInfo>
) : BaseResponse()