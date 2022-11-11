package com.sesac.planet.domain.usecase.main.plan

import com.sesac.planet.data.repository.main.plan.PlanRepository

class GetPlanUseCase {
    suspend operator fun invoke(token: String, journeyId: Int) = PlanRepository.getPlan(token, journeyId)
}