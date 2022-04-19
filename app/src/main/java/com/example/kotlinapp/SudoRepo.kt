package com.example.kotlinapp

import androidx.lifecycle.MutableLiveData

class SudoRepo(private val apiServiceImpl: ApiServiceImpl){
    suspend fun getResponse(): Response = apiServiceImpl.getResponse()
}
