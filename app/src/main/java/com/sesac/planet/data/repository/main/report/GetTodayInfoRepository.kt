package com.sesac.planet.data.repository.main.report

import com.sesac.planet.data.model.report.GetTodayInfoResponse
import com.sesac.planet.network.main.report.GetTodayInfoAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

object GetTodayInfoRepository {
    lateinit var getTodayInfoService: GetTodayInfoAPI

    suspend fun getTodayInfo(token: String, userId: Int): Response<GetTodayInfoResponse>{
        val response: Response<GetTodayInfoResponse>

        withContext(Dispatchers.IO){
            response = getTodayInfoService.getTodayInfoAPI(token, userId)
        }

        return response
    }
}