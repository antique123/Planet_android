package com.sesac.planet.data.repository

import com.sesac.planet.data.model.ReportResponse
import com.sesac.planet.network.ReportAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

object ReportRepository {
    lateinit var reportService: ReportAPI

    suspend fun getReport(token: String, userId: Int): Response<ReportResponse>{
        val response: Response<ReportResponse>

        withContext(Dispatchers.IO){
            response = reportService.getReport(token, userId)
        }

        return response
    }
}