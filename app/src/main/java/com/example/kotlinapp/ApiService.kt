package com.example.kotlinapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.http.GET
import retrofit2.http.HeaderMap

interface ApiService {
    @GET("/countries")
    suspend fun getResponse(@HeaderMap headers: Map<String, String>): Response
}