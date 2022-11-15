package com.sesac.planet.network.main.home

import com.sesac.planet.data.model.home.KeywordResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface KeywordAPI {
    @GET("/keyword/{journey_id}")
    suspend fun getKeyword(
        @Header("X-ACCESS-TOKEN") token: String,
        @Path("journey_id") journeyId: Int
    ): Response<KeywordResponse>
}