package com.example.kotlinapp

import com.google.gson.annotations.SerializedName

data class Deaths(
    val new: String,
    @SerializedName("1M_pop")
    val pop: String,
    val total: Integer
)