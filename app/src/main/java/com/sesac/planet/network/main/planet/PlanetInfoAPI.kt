package com.sesac.planet.network.main.planet

import com.sesac.planet.data.model.planet.PlanetInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface PlanetInfoAPI {
    @GET("/planets/{journey_id}")
    suspend fun getPlanet(
        @Header("X-ACCESS-TOKEN") token: String,
        @Path("journey_id") journeyId: Int
    ): Response<PlanetInfoResponse>
}