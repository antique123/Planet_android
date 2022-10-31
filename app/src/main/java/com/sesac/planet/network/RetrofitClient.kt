package com.sesac.planet.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    // 테스트 서버 주소
    val API_URL = "http://dev.wogus4048.shop/"

    // 실 서버 주소
    //val API_URL = "https://prod.ssacyj.shop/"

    private var instance: Retrofit? = null
    private val gson = GsonBuilder().setLenient().create()

    val client: OkHttpClient = OkHttpClient.Builder()
        .readTimeout(5000, TimeUnit.MILLISECONDS)
        .connectTimeout(5000, TimeUnit.MILLISECONDS)
        // 로그캣에 okhttp.OkHttpClient로 검색하면 http 통신 내용을 보여줌
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    fun getInstance(): Retrofit{
        if(instance == null){
            instance = Retrofit.Builder()
                .baseUrl(API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }

        return instance!!
    }
}