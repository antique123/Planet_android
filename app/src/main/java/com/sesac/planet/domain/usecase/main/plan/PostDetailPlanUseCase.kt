package com.sesac.planet.domain.usecase.main.plan

import com.sesac.planet.data.model.plan.PostDetailPlanRequest
import com.sesac.planet.data.repository.main.plan.PlanRepository

class PostDetailPlanUseCase {
    suspend operator fun invoke(
        token: String,
        journeyId: Int,
        planetId: Int,
        postDetailPlanRequest: PostDetailPlanRequest
    ) = PlanRepository.postPlan(token, journeyId, planetId, postDetailPlanRequest)
}