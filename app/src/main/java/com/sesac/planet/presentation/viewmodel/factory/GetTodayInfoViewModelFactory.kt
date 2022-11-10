package com.sesac.planet.presentation.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sesac.planet.domain.usecase.report.GetTodayInfoUseCase
import com.sesac.planet.presentation.viewmodel.main.report.GetTodayInfoViewModel

class GetTodayInfoViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(GetTodayInfoViewModel::class.java)){
            return GetTodayInfoViewModel(GetTodayInfoUseCase()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel from ExampleViewModelFactory")
    }
}