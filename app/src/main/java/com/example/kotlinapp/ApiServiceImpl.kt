package com.example.kotlinapp

import androidx.lifecycle.MutableLiveData

class ApiServiceImpl(private val api: ApiService) {
    suspend fun getResponse(): Response = api.getResponse(getHeadersMap())

    private fun getHeadersMap(): Map<String, String>{
        val headerMap = mutableMapOf<String, String>()
        headerMap["X-RapidAPI-Host"] = "covid-193.p.rapidapi.com"
        headerMap["X-RapidAPI-Key"] = "25b765628bmsheab7d9b25f691f6p1dc81djsnefd51f015226"
        return headerMap
    }
}