package com.capstone.destimate.view.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.capstone.destimate.data.repository.UserRepository

class SplashViewModel(private val userRepository: UserRepository): ViewModel() {

    fun getSession() = userRepository.getSession().asLiveData()
}