package com.sesac.planet.network

import com.sesac.planet.data.model.TodayGrowthPlansResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface PlanAPI {
    //홈화면에 오늘의 성장계획 리스트를 가져오는 api
    @GET("/plans/today/{journey_id}")
    fun getTodayGrowthPlans(
        @Header("X-ACCESS-TOKEN") token: String,
        @Path("journey_id") journeyId: Int
    ): Call<TodayGrowthPlansResponse>
}