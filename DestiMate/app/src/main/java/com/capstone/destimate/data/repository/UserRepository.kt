package com.capstone.destimate.data.repository

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import com.capstone.destimate.data.local.model.UserModel
import com.capstone.destimate.data.local.preference.UserPreference
import com.capstone.destimate.data.remote.response.ResponseLogin
import com.capstone.destimate.data.remote.response.ResponseSignUp
import com.capstone.destimate.data.remote.retrofit.ApiService
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(
    private val userPreference: UserPreference,
    private val apiService: ApiService
) {

    private var userModel: UserModel = UserModel("", "", false, "", "", false)
    private val loginResult = MediatorLiveData<Result<ResponseLogin>>()
    private val signUpResult = MediatorLiveData<Result<ResponseSignUp>>()


    fun login(email: String, password: String) {
        loginResult.value = Result.Loading
        val client = apiService.login(
//            email, password
        )
        client.enqueue(object : Callback<ResponseLogin> {
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                if (response.isSuccessful) {
                    val token = response.body()?.loginResult?.token
                    userModel.email = email
                    userModel.name = response.body()!!.loginResult.name
                    userModel.preferences = response.body()!!.loginResult.preference
                    userModel.photoUrl = response.body()!!.loginResult.photoUrl
                    userModel.token = token.toString()
                    userModel.isLogin = true

                    loginResult.value = Result.Success(response.body()!!)
                } else {
                    loginResult.value = Result.Error(response.message())
                }
            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
                loginResult.value = Result.Error("No internet")
            }
        })
    }

    fun signUp(
        image: MultipartBody.Part,
        nama: RequestBody,
        email: RequestBody,
        age: RequestBody,
        password: RequestBody,
        birthday: RequestBody
    ) {
        signUpResult.value = Result.Loading
        val client = apiService.signUp(
//            image, nama, email, age, password, birthday
        )
        client.enqueue(object : Callback<ResponseSignUp> {
            override fun onResponse(call: Call<ResponseSignUp>, response: Response<ResponseSignUp>) {
                if (response.isSuccessful) {
                    signUpResult.value = Result.Success(response.body()!!)
                } else {
                    signUpResult.value = Result.Error(response.message())
                }
            }

            override fun onFailure(call: Call<ResponseSignUp>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
                signUpResult.value = Result.Error("No internet")
            }
        })
    }


    fun getLoginResponse() = loginResult

    suspend fun saveSession() {
        userPreference.saveSession(userModel)
    }

    fun getSession(): Flow<UserModel> = this.userPreference.getSession()

    suspend fun logout(){
        userPreference.logout()
    }

    companion object {
        private const val TAG = "UserRepository"
    }
}