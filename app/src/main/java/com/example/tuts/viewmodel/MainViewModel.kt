package com.example.tuts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import com.example.tuts.repository.MainRepository
import com.example.tuts.utils.Resource

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {
    fun getUsers() = liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        } catch (exception: Exception){
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}