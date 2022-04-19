package com.example.kotlinapp.network

import com.example.kotlinapp.models.CountriesResponse
import com.example.kotlinapp.models.StatisticsResponse
import retrofit2.http.GET
import retrofit2.http.HeaderMap

interface ApiService {
    @GET("/countries")
    suspend fun getResponse(@HeaderMap headers: Map<String, String>): CountriesResponse
    @GET("/statistics")
    suspend fun getStats(@HeaderMap headers: Map<String, String>): StatisticsResponse
}