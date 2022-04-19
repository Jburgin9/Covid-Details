package com.example.kotlinapp.models

data class StatisticsResponse(
    val get: String,
    val results: String,
    val response: List<Stats>
)