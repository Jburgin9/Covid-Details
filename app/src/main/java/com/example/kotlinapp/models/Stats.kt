package com.example.kotlinapp.models

import com.example.kotlinapp.Cases
import com.example.kotlinapp.Deaths
import com.example.kotlinapp.Tests

data class Stats(
    val continent: String,
    val country: String,
    val population: Integer,
    val cases: Cases,
    val deaths: Deaths,
    val tests: Tests,
    val day: String,
    val time: String
)