package com.sesac.planet.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sesac.planet.data.model.PlanetInfoResponse
import com.sesac.planet.data.model.ResultPlanetInfo
import com.sesac.planet.network.PlanetInfoAPI
import com.sesac.planet.network.RetrofitClient
import retrofit2.*

class PlanetInfoRepository(application: Application) {
    private val retrofit = RetrofitClient.getInstance()
    private val service: PlanetInfoAPI = retrofit.create(PlanetInfoAPI::class.java)

    fun getPlanetData(): LiveData<List<ResultPlanetInfo>> {
        val data = MutableLiveData<List<ResultPlanetInfo>>()

        service.getPlanet(
            "eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NjY1OTQwOTcsImV4cCI6MTY2ODA2NTMyNn0.Ro1EyIxo44NIi1Jos7ssbCvkDdlSWhYPIBaMfabY7QQ",
            4
        ).enqueue(object : Callback<PlanetInfoResponse> {
            override fun onResponse(call: Call<PlanetInfoResponse>, response: Response<PlanetInfoResponse>) {
                data.value = response.body()?.result
            }

            override fun onFailure(call: Call<PlanetInfoResponse>, t: Throwable) {
                t.stackTrace
            }
        })

        return data
    }
}