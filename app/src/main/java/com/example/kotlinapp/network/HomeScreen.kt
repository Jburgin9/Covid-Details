package com.example.kotlinapp.network

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlinapp.MainViewModel
import com.example.kotlinapp.countriesList


@Composable
fun homeScreen(
    modifier: Modifier,
    mainViewModel: MainViewModel = viewModel()
){
    Column(){
        countriesList(mainViewModel)
    }
//    Column(modifier){
//        var list = mainViewModel.state.collectAsState()
//        Log.d("test", "homeScreen: ${list.value}")
//
//    }
}
