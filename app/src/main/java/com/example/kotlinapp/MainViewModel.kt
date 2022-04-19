package com.example.kotlinapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.kotlinapp.Utils.Resources
import com.example.kotlinapp.models.CountriesResponse
import com.example.kotlinapp.models.StatisticsResponse
import com.example.kotlinapp.network.SudoRepo
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val sudoRepo: SudoRepo): ViewModel() {
    val countriesResponse: MutableLiveData<CountriesResponse> = MutableLiveData()
    val statisticsResponse: MutableLiveData<StatisticsResponse> = MutableLiveData()

    fun getResponse() = liveData(Dispatchers.IO) {
        emit(Resources.loading(data = null))
        try {
            emit(Resources.success(data = sudoRepo.getResponse()))
            countriesResponse.value = sudoRepo.getResponse()
        } catch (exception: Exception) {
            emit(Resources.error(data = null, message = exception.message ?: "Error!"))

        }
    }

    fun getStats() = liveData(Dispatchers.IO) {
        emit(Resources.loading(data = null))
        try {
            emit(Resources.success(data = sudoRepo.getStats()))
            statisticsResponse.value = sudoRepo.getStats()
        } catch (e: Exception){
            emit(Resources.error(data = null, message = e.message ?: "Error"))
        }
    }
}