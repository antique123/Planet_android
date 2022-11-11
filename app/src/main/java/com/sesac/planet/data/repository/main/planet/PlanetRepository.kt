package com.sesac.planet.data.repository.main.planet

import com.sesac.planet.data.model.PlanetInfoResponse
import com.sesac.planet.network.main.planet.PlanetInfoAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


object PlanetRepository {
    lateinit var infoService: PlanetInfoAPI

    suspend fun getPlanet(token: String, journeyId: Int): Response<PlanetInfoResponse>{
        val response: Response<PlanetInfoResponse>

        withContext(Dispatchers.IO){
            response = infoService.getPlanet(token, journeyId)
        }

        return response
    }
}