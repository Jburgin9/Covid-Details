package com.example.kotlinapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val apiServiceImpl: ApiServiceImpl): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(SudoRepo(apiServiceImpl)) as T
        }
        throw IllegalArgumentException ("Unknown class name")
    }

}