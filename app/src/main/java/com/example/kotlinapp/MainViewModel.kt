package com.example.kotlinapp

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.*
import com.example.kotlinapp.Utils.Resources
import com.example.kotlinapp.Utils.Status
import com.example.kotlinapp.models.CountriesResponse
import com.example.kotlinapp.models.StatisticsResponse
import com.example.kotlinapp.network.ApiServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel (private val apiImpl: ApiServiceImpl): ViewModel() {
    val statisticsResponse: MutableLiveData<StatisticsResponse> = MutableLiveData()
    private val countries = MutableStateFlow(emptyList<String>())
    val state: StateFlow<List<String>> get() = countries

    init {
        getResponse()
    }


    fun getResponse()  {
       viewModelScope.launch {
           withContext(Dispatchers.IO){
               countries.value = apiImpl.getResponse()
           }
       }
    }

    fun getStats() = liveData(Dispatchers.IO) {
        emit(Resources.loading(data = null))
        try {
            emit(Resources.success(data = apiImpl.getStats()))
            statisticsResponse.value = apiImpl.getStats()

        } catch (e: Exception){
            emit(Resources.error(data = null, message = e.message ?: "Error"))
        }
    }

}
