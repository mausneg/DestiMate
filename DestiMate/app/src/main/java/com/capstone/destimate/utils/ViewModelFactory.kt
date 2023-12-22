package com.capstone.destimate.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.capstone.destimate.data.repository.DestinationRepository
import com.capstone.destimate.data.repository.UserRepository
import com.capstone.destimate.di.Injection
import com.capstone.destimate.view.detail.DetailViewModel
import com.capstone.destimate.view.login.LoginViewModel
import com.capstone.destimate.view.main.MainViewModel
import com.capstone.destimate.view.splash.SplashViewModel
import com.capstone.destimate.view.userdetail.UserViewModel

class ViewModelFactory private constructor(
    private val destinationRepository: DestinationRepository,
    private val userRepository: UserRepository
) : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SplashViewModel::class.java)){
            return SplashViewModel(userRepository) as T
        } else if (modelClass.isAssignableFrom(LoginViewModel::class.java)){
            return LoginViewModel(userRepository) as T
        } else if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(userRepository, destinationRepository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(destinationRepository) as T
        } else if (modelClass.isAssignableFrom(UserViewModel::class.java)){
            return UserViewModel(userRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object{
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory = instance ?: synchronized(this){
            instance ?: ViewModelFactory(
                Injection.provideDestinationRepository(context),
                Injection.provideUserRepository(context)
            )
        }.also {
            instance = it
        }
    }
}