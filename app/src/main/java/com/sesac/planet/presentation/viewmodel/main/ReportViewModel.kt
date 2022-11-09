package com.sesac.planet.presentation.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sesac.planet.config.PlanetApplication
import com.sesac.planet.data.model.ReportResponse
import com.sesac.planet.data.repository.ReportRepository
import com.sesac.planet.domain.usecase.ReportUseCase
import com.sesac.planet.network.ReportAPI
import kotlinx.coroutines.launch
import retrofit2.Response

class ReportViewModel(private val getReportUseCase: ReportUseCase): ViewModel() {
    private val _reportData = MutableLiveData<Response<ReportResponse>>()
    val reportData: LiveData<Response<ReportResponse>> get() = _reportData

    init {
        ReportRepository.reportService = PlanetApplication.getInstance().create(ReportAPI::class.java)
    }

    fun getReport(token: String, userId: Int){
        viewModelScope.launch {
            val response = getReportUseCase(token, userId)
            _reportData.value = response
        }
    }
}