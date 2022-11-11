package com.sesac.planet.domain.usecase

import com.sesac.planet.data.model.MakeJourneyRequest
import com.sesac.planet.data.repository.main.plan.PlanRepository

class MakeJourneyUseCase {
    suspend operator fun invoke(makeJourneyRequest: MakeJourneyRequest, token: String, userId: Int) = PlanRepository.makeJourney(makeJourneyRequest, token, userId)
}