package com.sesac.planet.domain.usecase.main.planet

import com.sesac.planet.data.repository.main.planet.PlanetDetailRepository

class GetPlanetDetailInfoUseCase{
    suspend operator fun invoke(token: String, planetId: Int) = PlanetDetailRepository.getPlanetDetailInfo(token, planetId)
}