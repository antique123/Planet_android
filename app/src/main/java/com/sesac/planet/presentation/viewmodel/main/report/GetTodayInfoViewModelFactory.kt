package com.sesac.planet.presentation.viewmodel.main.report

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sesac.planet.domain.usecase.main.report.GetTodayInfoUseCase

class GetTodayInfoViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(GetTodayInfoViewModel::class.java)){
            return GetTodayInfoViewModel(GetTodayInfoUseCase()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel from ExampleViewModelFactory")
    }
}