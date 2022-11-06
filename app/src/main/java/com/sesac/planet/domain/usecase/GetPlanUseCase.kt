package com.sesac.planet.domain.usecase

import com.sesac.planet.data.repository.PlanRepository

class GetPlanUseCase {
    suspend operator fun invoke(token: String, journeyId: Int) = PlanRepository.getPlan(token, journeyId)
}