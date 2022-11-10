package com.sesac.planet.data.repository

import com.sesac.planet.data.model.MakeJourneyRequest
import com.sesac.planet.data.model.BaseResponse
import com.sesac.planet.data.model.PostDetailPlanRequest
import com.sesac.planet.data.model.TodayGrowthPlansResponse
import com.sesac.planet.network.PlanAPI
import com.sesac.planet.network.PostDetailPlanAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

object PlanRepository {
    lateinit var planService: PlanAPI
    lateinit var postPlanService: PostDetailPlanAPI

    suspend fun getPlan(token: String, journeyId: Int): Response<TodayGrowthPlansResponse>{
        val response: Response<TodayGrowthPlansResponse>

        withContext(Dispatchers.IO){
            response = planService.getTodayGrowthPlans(token, journeyId)
        }

        return response
    }

    suspend fun makeJourney(journeyRequest: MakeJourneyRequest, token: String, userId: Int) = withContext(Dispatchers.IO) {
        planService.makeJourney(userId, token, journeyRequest)
    }

    suspend fun postPlan(token: String, journeyId: Int, planetId: Int, postDetailPlanRequest: PostDetailPlanRequest): Response<BaseResponse>{
        val postPlanResponse: Response<BaseResponse>

        withContext(Dispatchers.IO){
            postPlanResponse = postPlanService.postDetailPlan(token, journeyId, planetId, postDetailPlanRequest)
        }

        return postPlanResponse
    }
}