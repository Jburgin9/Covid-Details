package com.example.kotlinapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinapp.network.ApiServiceImpl
import com.example.kotlinapp.network.SudoRepo

class ViewModelFactory(private val apiServiceImpl: ApiServiceImpl): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(apiServiceImpl) as T
        }
        throw IllegalArgumentException ("Unknown class name")
    }

}