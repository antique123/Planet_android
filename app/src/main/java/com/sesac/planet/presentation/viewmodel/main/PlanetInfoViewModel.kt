package com.sesac.planet.presentation.viewmodel.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sesac.planet.config.PlanetApplication
import com.sesac.planet.data.model.PlanetInfoResponse
import com.sesac.planet.data.repository.PlanetRepository
import com.sesac.planet.domain.usecase.GetPlanetUseCase
import com.sesac.planet.network.PlanetInfoAPI
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class PlanetInfoViewModel(private val getPlanetUseCase: GetPlanetUseCase): ViewModel(){
    private val _planetData = MutableLiveData<Response<PlanetInfoResponse>>()
    val planetData get(): LiveData<Response<PlanetInfoResponse>> = _planetData

    init {
        PlanetRepository.infoService = PlanetApplication.getInstance().create(PlanetInfoAPI::class.java)
    }

    fun getPlanet(token: String, journeyId: Int){
        viewModelScope.launch {
            val response = getPlanetUseCase(token, journeyId)
            _planetData.value = response
        }
    }
}