package com.capstone.destimate.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.capstone.destimate.data.repository.DestinationRepository
import com.capstone.destimate.data.repository.UserRepository
import kotlinx.coroutines.launch

class MainViewModel(private val userRepository: UserRepository, private val destinationRepository: DestinationRepository) : ViewModel(){

    fun setRecommendation() = viewModelScope.launch{
        destinationRepository.setRecommendation()
    }

    fun setNearby(lat: Float, lon: Float) = viewModelScope.launch {
        destinationRepository.setNearby(lat, lon)
    }

    fun setFavorite() = viewModelScope.launch {
        destinationRepository.setFavorite()
    }

    fun getRecommendation() = destinationRepository.getRecommendation()

    fun getNearby() = destinationRepository.getNearby()

    fun getFavorite() = destinationRepository.getFavorite()

    fun getSession() = userRepository.getSession().asLiveData()

}