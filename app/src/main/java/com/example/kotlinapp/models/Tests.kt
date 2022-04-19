package com.example.kotlinapp

import com.google.gson.annotations.SerializedName

data class Tests(
    @SerializedName("1M_pop")
    val pop: Integer,
    val total: Integer
)