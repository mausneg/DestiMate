package com.capstone.destimate.di

import android.content.Context
import com.capstone.destimate.data.local.preference.UserPreference
import com.capstone.destimate.data.local.preference.dataStore
import com.capstone.destimate.data.repository.DestinationRepository
import com.capstone.destimate.data.repository.UserRepository
import com.capstone.destimatecapstone.data.remote.retrofit.ApiConfig

object Injection {

    fun provideDestinationRepository(context: Context): DestinationRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        val apiService = ApiConfig.getApiService()
        return DestinationRepository(pref, apiService)
    }

    fun provideUserRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        val apiService = ApiConfig.getApiService()
        return UserRepository(pref, apiService)
    }
}