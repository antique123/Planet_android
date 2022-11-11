package com.sesac.planet.presentation.viewmodel.main.planet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sesac.planet.domain.usecase.main.planet.GetPlanetUseCase

class PlanetViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PlanetInfoViewModel::class.java)) {
            return PlanetInfoViewModel(GetPlanetUseCase()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel from ExampleViewModelFactory")
    }
}