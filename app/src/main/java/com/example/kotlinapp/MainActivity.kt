package com.example.kotlinapp

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinapp.Utils.Status
import com.example.kotlinapp.databinding.ActivityMainBinding
import com.example.kotlinapp.network.ApiServiceImpl
import com.example.kotlinapp.network.RetrofitBuilder

class MainActivity :AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()
        setupObservers()
        getStats()
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
                    val adapter: ArrayAdapter<String> = ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, resource.data!!.response)
                    binding.countriesSpinner.adapter = adapter
                }
                Status.LOADING -> {

                }
                Status.ERROR -> {

                }
            }
        } })
    }

    private fun getStats(){
        viewModel.getStats().observe(this, {it?.let {
            resource ->  when (resource.status) {
                Status.SUCCESS -> {
                    Log.d("test", "getStats: " + resource.data!!.response)
                }
                Status.LOADING -> {
                    Log.d("test", "getStats: loading")
                }
                Status.ERROR -> {
                    Log.d("test", "getStats: ${resource.message}")
                }
            }
        }})
    }
}