package com.sesac.planet.domain.usecase.report

import com.sesac.planet.data.repository.report.GetTodayInfoRepository

class GetTodayInfoUseCase {
    suspend operator fun invoke(token: String, userId: Int) = GetTodayInfoRepository.getTodayInfo(token, userId)
}