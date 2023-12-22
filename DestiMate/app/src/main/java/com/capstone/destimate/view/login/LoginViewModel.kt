package com.capstone.destimate.view.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.destimate.data.repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val userRepository: UserRepository): ViewModel() {

    fun login(
        email: String, password: String
    ) = viewModelScope.launch {
        userRepository.login(email, password)
    }

    fun saveSession() = viewModelScope.launch {
        userRepository.saveSession()
    }

    fun getLoginResult() = userRepository.getLoginResponse()

}