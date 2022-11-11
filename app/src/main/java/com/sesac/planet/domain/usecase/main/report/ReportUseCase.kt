package com.sesac.planet.domain.usecase.main.report

import com.sesac.planet.data.repository.main.report.ReportRepository

class ReportUseCase {
    suspend operator fun invoke(token: String, userId: Int) = ReportRepository.getReport(token, userId)
}