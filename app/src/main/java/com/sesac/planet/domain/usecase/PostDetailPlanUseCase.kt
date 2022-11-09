package com.sesac.planet.domain.usecase

import com.sesac.planet.data.model.PostDetailPlanRequest
import com.sesac.planet.data.repository.PlanRepository

class PostDetailPlanUseCase {
    suspend operator fun invoke(token: String, journeyId:Int, planetId: Int, postDetailPlanRequest: PostDetailPlanRequest) = PlanRepository.postPlan(token, journeyId, planetId, postDetailPlanRequest)
}