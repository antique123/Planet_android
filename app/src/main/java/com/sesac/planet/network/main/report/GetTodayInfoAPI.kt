package com.sesac.planet.network.main.report

import com.sesac.planet.data.model.report.GetTodayInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface GetTodayInfoAPI {
    @GET("/report/today/{user_id}")
    suspend fun getTodayInfoAPI(
        @Header("X-ACCESS-TOKEN") token: String,
        @Path("user_id") journeyId: Int
    ): Response<GetTodayInfoResponse>
}