package com.sesac.planet.domain.usecase

import com.sesac.planet.data.repository.KeywordRepository

class GetKeywordUseCase {
    suspend operator fun invoke(token: String, journeyId: Int) = KeywordRepository.getKeyword(token, journeyId)
}