package com.example.kotlinapp.network

import com.example.kotlinapp.models.CountriesResponse
import com.example.kotlinapp.models.StatisticsResponse
import com.example.kotlinapp.network.ApiServiceImpl

class SudoRepo(private val apiServiceImpl: ApiServiceImpl){
    suspend fun getResponse(): CountriesResponse = apiServiceImpl.getResponse()
    suspend fun getStats(): StatisticsResponse = apiServiceImpl.getStats()
}
