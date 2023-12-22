package com.capstone.destimate.data.local.preference

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.capstone.destimate.data.local.model.UserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "session")

class UserPreference private constructor(private val dataStore: DataStore<Preferences>){

    suspend fun saveSession(user: UserModel){
        dataStore.edit {
            it[EMAIL_KEY] = user.email
            it[NAME_KEY] = user.name
            it[PREFERENCES_KEY] = user.preferences
            it[PHOTO_URL_KEY] = user.photoUrl
            it[TOKEN_KEY] = user.token
            it[IS_LOGIN_KEY] = user.isLogin
        }
    }

    fun getSession() : Flow<UserModel> {
        return dataStore.data.map {
            UserModel(
                it[EMAIL_KEY] ?: "",
                it[NAME_KEY] ?: "",
                it[PREFERENCES_KEY] ?: false,
                it[PHOTO_URL_KEY] ?: "",
                it[TOKEN_KEY] ?: "",
                it[IS_LOGIN_KEY] ?: false,
            )
        }
    }

    suspend fun logout() {
        dataStore.edit {
            it.clear()
        }
    }

    companion object{
        @Volatile
        private var INSTANCE: UserPreference? = null

        private val EMAIL_KEY = stringPreferencesKey("email")
        private val NAME_KEY = stringPreferencesKey("name")
        private val PREFERENCES_KEY = booleanPreferencesKey("preferences")
        private val PHOTO_URL_KEY = stringPreferencesKey("photoUrl")
        private val TOKEN_KEY = stringPreferencesKey("token")
        private val IS_LOGIN_KEY = booleanPreferencesKey("isLogin")

        fun getInstance(dataStore: DataStore<Preferences>): UserPreference{
            return INSTANCE ?: synchronized(this){
                val instance = UserPreference(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}