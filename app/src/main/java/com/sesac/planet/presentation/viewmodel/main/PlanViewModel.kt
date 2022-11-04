package com.sesac.planet.presentation.viewmodel.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sesac.planet.data.model.ResultTodayGrowthPlans
import com.sesac.planet.data.model.TodayGrowthPlansResponse
import com.sesac.planet.data.repository.PlanRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlanViewModel: ViewModel() {
    private val repository: PlanRepository = PlanRepository()

    private val _data: MutableLiveData<List<ResultTodayGrowthPlans>> = MutableLiveData()
    val data: LiveData<List<ResultTodayGrowthPlans>> get() = _data

    fun setData() {
        repository.getTodayGrowthPlans().enqueue(object : Callback<TodayGrowthPlansResponse>{
            override fun onResponse(
                call: Call<TodayGrowthPlansResponse>,
                response: Response<TodayGrowthPlansResponse>
            ) {
                _data.value = response.body()?.result
            }

            override fun onFailure(call: Call<TodayGrowthPlansResponse>, t: Throwable) {
                t.stackTrace
            }
        })
    }
}