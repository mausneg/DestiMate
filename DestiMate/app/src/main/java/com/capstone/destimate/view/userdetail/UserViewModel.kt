package com.capstone.destimate.view.userdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.capstone.destimate.data.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository): ViewModel() {

    fun getSession() = userRepository.getSession().asLiveData()

    fun logout() = viewModelScope.launch {
        userRepository.logout()
    }
}