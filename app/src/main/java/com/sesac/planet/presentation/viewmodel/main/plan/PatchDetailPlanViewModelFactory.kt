package com.sesac.planet.presentation.viewmodel.main.plan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sesac.planet.domain.usecase.main.plan.PatchDetailPlanUseCase

class PatchDetailPlanViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PatchDetailPlanViewModel::class.java)){
            return PatchDetailPlanViewModel(PatchDetailPlanUseCase()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel from ExampleViewModelFactory")
    }
}