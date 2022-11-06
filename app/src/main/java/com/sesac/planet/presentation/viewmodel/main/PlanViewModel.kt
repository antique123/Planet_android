package com.sesac.planet.presentation.viewmodel.main

import androidx.lifecycle.*
import com.sesac.planet.config.PlanetApplication
import com.sesac.planet.data.model.TodayGrowthPlansResponse
import com.sesac.planet.data.repository.PlanRepository
import com.sesac.planet.domain.usecase.GetPlanUseCase
import com.sesac.planet.network.PlanAPI
import kotlinx.coroutines.launch
import retrofit2.Response

class PlanViewModel(private val getPlanUseCase: GetPlanUseCase): ViewModel() {
    private val _planData = MutableLiveData<Response<TodayGrowthPlansResponse>>()
    val planData: LiveData<Response<TodayGrowthPlansResponse>> get() = _planData

    init {
        PlanRepository.planService = PlanetApplication.getInstance().create(PlanAPI::class.java)
    }

    fun getPlan(token: String, journeyId: Int){
        viewModelScope.launch {
            val response = getPlanUseCase(token, journeyId)
            _planData.value = response
        }
    }
}