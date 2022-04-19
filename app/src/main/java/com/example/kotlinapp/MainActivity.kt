package com.example.kotlinapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity :AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupObservers()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(ApiServiceImpl(RetrofitBuilder.apiService)))
            .get(MainViewModel::class.java)
    }

    private fun setupObservers(){
        viewModel.getResponse().observe(this, Observer { it?.let {
            resource -> when (resource.status) {
                Status.SUCCESS -> {
                    Log.d("test", "setupObservers: ${resource.data!!.response[2]}")

                }
                Status.LOADING -> {

                }
                Status.ERROR -> {

                }
            }
        } })
    }

}