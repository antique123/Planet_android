package com.sesac.planet.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sesac.planet.data.model.PlanetInfoResponse
import com.sesac.planet.data.model.ResultPlanetInfo
import com.sesac.planet.data.model.ResultTodayGrowthPlans
import com.sesac.planet.data.model.TodayGrowthPlansResponse
import com.sesac.planet.network.PlanAPI
import com.sesac.planet.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlanRepository(application: Application) {
    private val retrofit = RetrofitClient.getInstance()
    private val service: PlanAPI = retrofit.create(PlanAPI::class.java)

    fun getTodayGrowthPlans(): LiveData<List<ResultTodayGrowthPlans>> {
        val data = MutableLiveData<List<ResultTodayGrowthPlans>>()

        service.getTodayGrowthPlans(
            "eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NjY1OTQwOTcsImV4cCI6MTY2ODA2NTMyNn0.Ro1EyIxo44NIi1Jos7ssbCvkDdlSWhYPIBaMfabY7QQ",
            4
        ).enqueue(object : Callback<TodayGrowthPlansResponse> {
            override fun onResponse(
                call: Call<TodayGrowthPlansResponse>,
                response: Response<TodayGrowthPlansResponse>
            ) {
                data.value = response.body()?.result
            }

            override fun onFailure(call: Call<TodayGrowthPlansResponse>, t: Throwable) {
                t.stackTrace
            }
        })

        return data
    }
}