package com.sesac.planet.domain.usecase

import com.sesac.planet.data.repository.PlanetRepository

class GetPlanetUseCase {
    suspend operator fun invoke(token: String, journeyId: Int) = PlanetRepository.getPlanet(token, journeyId)
}