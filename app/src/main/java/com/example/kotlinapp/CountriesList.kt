package com.example.kotlinapp

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun countriesList(
    viewModel: MainViewModel
){
    Row {
        country(viewModel)
    }
//    LazyColumn {
//               items(
//            items = viewModel.state.value,
//        ){ item  ->
////            country(name = item)
//        }
//    }
}