package com.sesac.planet.network.main.report

import com.sesac.planet.data.model.ReportResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ReportAPI {
    @GET("/report/{user_id}")
    suspend fun getReport(
        @Header("X-ACCESS-TOKEN") token: String,
        @Path("user_id") userId: Int
    ): Response<ReportResponse>
}