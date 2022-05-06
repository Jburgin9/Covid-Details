package com.example.kotlinapp

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.*
import com.example.kotlinapp.Utils.Status
import com.example.kotlinapp.network.ApiServiceImpl
import com.example.kotlinapp.network.RetrofitBuilder
import com.example.kotlinapp.network.homeScreen

class MainActivity :AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
        setContent {
           homeScreen(modifier = Modifier, viewModel)
        }

    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(ApiServiceImpl(RetrofitBuilder.apiService)))
            .get(MainViewModel::class.java)
    }

//    private fun setupObservers(){
//        viewModel.getResponse().observe(this, Observer { it?.let {
//            resource -> when (resource.status) {
//                Status.SUCCESS -> {
//
//                }
//                Status.LOADING -> {
//
//                }
//                Status.ERROR -> {
//
//                }
//            }
//        } })
//    }

    private fun getStats(){
        viewModel.getStats().observe(this, Observer { it?.let {
            resource ->  when (resource.status) {
                Status.SUCCESS -> {
                    Log.d("test", "getStats: " + resource.data!!.response)
                }
                Status.LOADING -> {
                }
                Status.ERROR -> {
                }
            }
        }})
    }

    @Composable
    fun showText(curr: LiveData<List<String>>){
            Log.d("list", "showText: ${curr.value!!.size}")
    }
}