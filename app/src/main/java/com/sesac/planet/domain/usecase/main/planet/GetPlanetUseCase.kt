package com.sesac.planet.domain.usecase.main.planet

import com.sesac.planet.data.repository.main.planet.PlanetRepository

class GetPlanetUseCase {
    suspend operator fun invoke(token: String, journeyId: Int) = PlanetRepository.getPlanet(token, journeyId)
}