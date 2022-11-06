package com.sesac.planet.presentation.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sesac.planet.domain.usecase.GetPlanetUseCase

class PlanetViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PlanetInfoViewModel::class.java)) {
            return PlanetInfoViewModel(GetPlanetUseCase()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel from ExampleViewModelFactory")
    }
}