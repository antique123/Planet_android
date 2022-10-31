package com.sesac.planet.presentation.viewmodel.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.sesac.planet.data.model.ResultTodayGrowthPlans
import com.sesac.planet.data.repository.PlanRepository

class PlanViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = PlanRepository(application)

    fun getTodayGrowthPlans(): LiveData<List<ResultTodayGrowthPlans>>{
        return repository.getTodayGrowthPlans()
    }
}