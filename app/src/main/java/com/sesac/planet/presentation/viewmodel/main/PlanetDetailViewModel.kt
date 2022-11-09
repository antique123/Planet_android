package com.sesac.planet.presentation.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sesac.planet.config.PlanetApplication
import com.sesac.planet.data.model.PlanetDetailInfoResponse
import com.sesac.planet.data.model.TodayGrowthPlansResponse
import com.sesac.planet.data.repository.PlanRepository
import com.sesac.planet.data.repository.PlanetDetailRepository
import com.sesac.planet.domain.usecase.GetPlanUseCase
import com.sesac.planet.domain.usecase.GetPlanetDetailInfoUseCase
import com.sesac.planet.network.PlanAPI
import com.sesac.planet.network.PlanetDetailAPI
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.create

class PlanetDetailViewModel (private val getPlanetDetailInfoUseCase: GetPlanetDetailInfoUseCase): ViewModel() {
    private val _planetDetailData = MutableLiveData<Response<PlanetDetailInfoResponse>>()
    val planetDetailData: LiveData<Response<PlanetDetailInfoResponse>> get() = _planetDetailData

    init {
        PlanetDetailRepository.planetDetailService = PlanetApplication.getInstance().create(PlanetDetailAPI::class.java)
    }

    fun getPlanetDetailInfo(token: String, planetId: Int){
        viewModelScope.launch {
            val response = getPlanetDetailInfoUseCase(token, planetId)
            _planetDetailData.value = response
        }
    }
}