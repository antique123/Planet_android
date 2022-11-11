package com.sesac.planet.domain.usecase.main.report

import com.sesac.planet.data.repository.main.report.GetTodayInfoRepository

class GetTodayInfoUseCase {
    suspend operator fun invoke(token: String, userId: Int) = GetTodayInfoRepository.getTodayInfo(token, userId)
}