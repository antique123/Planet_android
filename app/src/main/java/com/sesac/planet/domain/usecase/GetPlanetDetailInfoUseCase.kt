package com.sesac.planet.domain.usecase

import com.sesac.planet.data.repository.PlanetDetailRepository

class GetPlanetDetailInfoUseCase{
    suspend operator fun invoke(token: String, planetId: Int) = PlanetDetailRepository.getPlanetDetailInfo(token, planetId)
}