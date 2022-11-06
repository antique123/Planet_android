package com.sesac.planet.data.repository

import com.sesac.planet.data.model.TodayGrowthPlansResponse
import com.sesac.planet.network.PlanAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

object PlanRepository {
    lateinit var planService: PlanAPI

    suspend fun getPlan(token: String, journeyId: Int): Response<TodayGrowthPlansResponse>{
        val response: Response<TodayGrowthPlansResponse>

        withContext(Dispatchers.IO){
            response = planService.getTodayGrowthPlans(token, journeyId)
        }

        return response
    }
}