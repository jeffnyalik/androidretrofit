package com.example.tuts.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import com.example.tuts.api.ApiHelper
import com.example.tuts.repository.MainRepository

class ViewModelFactory(private val apiHelper: ApiHelper): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}