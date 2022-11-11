package com.sesac.planet.domain.usecase.main.home

import com.sesac.planet.data.repository.main.home.KeywordRepository

class GetKeywordUseCase {
    suspend operator fun invoke(token: String, journeyId: Int) = KeywordRepository.getKeyword(token, journeyId)
}