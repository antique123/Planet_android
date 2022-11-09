package com.sesac.planet.network

import com.sesac.planet.data.model.BaseResponse
import com.sesac.planet.data.model.PostDetailPlanRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface PostDetailPlanAPI {
    @POST("/plans/{journey_id}/{planet_id}")
    suspend fun postDetailPlan(
        @Header("X-ACCESS-TOKEN") token: String,
        @Path("journey_id") journeyId: Int,
        @Path("planet_id") planetId: Int,
        @Body params: PostDetailPlanRequest
    ): Response<BaseResponse>
}