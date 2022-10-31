package com.sesac.planet.network

import com.sesac.planet.data.model.PlanetInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface PlanetInfoAPI {
    @GET("/planets/{journey_id}")
    fun getPlanet(
        @Header("X-ACCESS-TOKEN") token: String,
        @Path("journey_id") journeyId: Int
    ): Call<PlanetInfoResponse>
}