package com.example.kotlinapp

import com.google.gson.annotations.SerializedName

data class Cases(
    val new: Integer,
    val active: Integer,
    val critical: Integer,
    val recovered: Integer,
    @SerializedName("1M_pop")
    val pop: String,
    val total: Integer
)