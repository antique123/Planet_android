package com.sesac.planet.presentation.viewmodel.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sesac.planet.data.model.PlanetInfoResponse
import com.sesac.planet.data.model.ResultPlanetInfo
import com.sesac.planet.data.repository.PlanetInfoRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlanetInfoViewModel: ViewModel(){
    private val repository = PlanetInfoRepository()

    private val _itemList = MutableLiveData<List<ResultPlanetInfo>>()
    val itemList: LiveData<List<ResultPlanetInfo>> get() = _itemList

    fun setData(){
        repository.getPlanetData().enqueue(object : Callback<PlanetInfoResponse>{
            override fun onResponse(
                call: Call<PlanetInfoResponse>,
                response: Response<PlanetInfoResponse>
            ) {
                _itemList.value = response.body()?.result
            }

            override fun onFailure(call: Call<PlanetInfoResponse>, t: Throwable) {
                t.stackTrace
                Log.e("ERROR","비상!! 비상!!")
            }
        })
    }
}