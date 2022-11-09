package com.sesac.planet.data.repository

import com.sesac.planet.data.model.PlanetDetailInfoResponse
import com.sesac.planet.network.PlanetDetailAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

object PlanetDetailRepository {
    lateinit var planetDetailService: PlanetDetailAPI

    suspend fun getPlanetDetailInfo(token: String, planetId: Int): Response<PlanetDetailInfoResponse>{
        val response: Response<PlanetDetailInfoResponse>

        withContext(Dispatchers.IO){
            response = planetDetailService.getPlanetDetailInfo(token, planetId)
        }

        return response
    }
}