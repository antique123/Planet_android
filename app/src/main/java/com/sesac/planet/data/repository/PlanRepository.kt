package com.sesac.planet.data.repository

import com.sesac.planet.data.model.TodayGrowthPlansResponse
import com.sesac.planet.network.PlanAPI
import com.sesac.planet.network.RetrofitClient
import retrofit2.Call

class PlanRepository() {
    private val retrofit = RetrofitClient.getInstance()
    private val service: PlanAPI = retrofit.create(PlanAPI::class.java)

    fun getTodayGrowthPlans(): Call<TodayGrowthPlansResponse> {
        return service.getTodayGrowthPlans(
            "eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NjY1OTQwOTcsImV4cCI6MTY2ODA2NTMyNn0.Ro1EyIxo44NIi1Jos7ssbCvkDdlSWhYPIBaMfabY7QQ",
            4
        )
    }
}