package com.sesac.planet.presentation.viewmodel.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sesac.planet.data.model.ResultPlanetInfo
import com.sesac.planet.data.repository.PlanetInfoRepository

class PlanetInfoViewModel(application: Application) : AndroidViewModel(application){
    private val repository = PlanetInfoRepository(application)

    private val _itemList = MutableLiveData<List<ResultPlanetInfo>>()
    val itemList: LiveData<List<ResultPlanetInfo>> = _itemList

    init {
        _itemList.value = repository.getPlanetData().value
    }

    fun getPlanets(): LiveData<List<ResultPlanetInfo>>{
        return repository.getPlanetData()
    }
}