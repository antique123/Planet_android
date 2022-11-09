package com.sesac.planet.config

import android.app.Application
import android.content.SharedPreferences
import com.kakao.sdk.common.KakaoSdk
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//앱이 실행될 때 1번만 실행이 됩니다.
class PlanetApplication : Application() {

    companion object{
        // 테스트 서버 주소
        val BASE_URL = "https://dev.wogus4048.shop/"
        val X_ACCESS_TOKEN = "X-ACCESS-TOKEN"
        val USER_ID = "USER_ID"

        private var instance: Retrofit? = null
        lateinit var sharedPreferences: SharedPreferences

        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            // 로그캣에 okhttp.OkHttpClient로 검색하면 http 통신 내용을 보여줍니다.
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        // sRetrofit 이라는 전역변수에 API url, 인터셉터, Gson을 넣어주고 빌드해주는 코드
        // 이 전역변수로 http 요청을 서버로 보내면 됩니다.
        fun getInstance() : Retrofit{
            if(instance == null){
                instance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return instance!!
        }

        fun isLoginUser(): Boolean {
            val jwt = sharedPreferences.getString(X_ACCESS_TOKEN, "")
            return !jwt?.isEmpty()!!
        }
    }

    override fun onCreate() {
        super.onCreate()

        //카카오 로그인 sdk 초기화
        KakaoSdk.init(this, "35566e7214f726dff89f6addb3b88c1e")
        initSharedPreferences()
    }

    private fun initSharedPreferences() {
        sharedPreferences = applicationContext.getSharedPreferences("PLANET_SF", MODE_PRIVATE)
    }


}