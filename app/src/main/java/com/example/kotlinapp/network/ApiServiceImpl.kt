package com.example.kotlinapp.network

import com.example.kotlinapp.models.CountriesResponse
import com.example.kotlinapp.models.StatisticsResponse


class ApiServiceImpl (private val api: ApiService) {
    suspend fun getResponse(): List<String> = api.getResponse(getHeadersMap()).response
    suspend fun getStats(): StatisticsResponse = api.getStats(getHeadersMap())

    private fun getHeadersMap(): Map<String, String>{
        val headerMap = mutableMapOf<String, String>()
        headerMap["X-RapidAPI-Host"] = "covid-193.p.rapidapi.com"
        headerMap["X-RapidAPI-Key"] = "25b765628bmsheab7d9b25f691f6p1dc81djsnefd51f015226"
        return headerMap
    }
}