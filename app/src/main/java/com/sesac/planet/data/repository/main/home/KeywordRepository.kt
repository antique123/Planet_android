package com.sesac.planet.data.repository.main.home

import com.sesac.planet.data.model.home.KeywordResponse
import com.sesac.planet.network.main.home.KeywordAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

object KeywordRepository {
    lateinit var keywordService: KeywordAPI

    suspend fun getKeyword(token: String, journeyId: Int): Response<KeywordResponse>{
        val response: Response<KeywordResponse>

        withContext(Dispatchers.IO){
            response = keywordService.getKeyword(token, journeyId)
        }

        return response
    }
}