package com.example.kotlinapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val sudoRepo: SudoRepo): ViewModel() {
    val myResponse: MutableLiveData<Response> = MutableLiveData()

    fun getResponse() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = sudoRepo.getResponse()))
            myResponse.value = sudoRepo.getResponse()
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error!"))
        }
    }
}