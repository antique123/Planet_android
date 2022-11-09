package com.sesac.planet.domain.usecase

import com.sesac.planet.data.repository.ReportRepository

class ReportUseCase {
    suspend operator fun invoke(token: String, userId: Int) = ReportRepository.getReport(token, userId)
}