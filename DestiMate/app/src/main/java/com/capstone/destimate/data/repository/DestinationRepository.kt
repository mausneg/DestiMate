package com.capstone.destimate.data.repository

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.capstone.destimate.data.local.model.DestinationModel
import com.capstone.destimate.data.local.preference.UserPreference
import com.capstone.destimate.data.remote.response.Destination
import com.capstone.destimate.data.remote.response.ResponseDestination
import com.capstone.destimate.data.remote.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DestinationRepository(
    private val userPreference: UserPreference,
    private val apiService: ApiService
) {

    private val recommendationResult = MediatorLiveData<Result<List<Destination>>>()
    private val nearbyResult = MediatorLiveData<Result<List<Destination>>>()
    private val favoriteResult = MediatorLiveData<Result<List<Destination>>>()
    private val destinasiSerupaResult = MediatorLiveData<Result<List<Destination>>>()
    private val destinationDetail = MutableLiveData<DestinationModel>()

    fun setDestinationDetail(data: DestinationModel){
        destinationDetail.value = data
    }
    fun getDestinationDetail() = destinationDetail

    fun setDestinasiSerupa(placeId: Int){
        destinasiSerupaResult.value = Result.Loading
//        val token = runBlocking { userPreference.getSession().first().token }
//        val bearerToken = "Bearer $token"
//        val response = apiService.getDestinasiSerupa(bearerToken, placeId)
        val response = apiService.getDestinasiSerupa()

        response.enqueue(object : Callback<ResponseDestination> {
            override fun onResponse(
                call: Call<ResponseDestination>,
                response: Response<ResponseDestination>
            ) {
                val listData = response.body()
                if (response.isSuccessful && listData != null){
                    destinasiSerupaResult.value = Result.Success(listData.listDestination)
                }else{
                    Log.e(TAG, "onFailure: ${response.message()}")
                    destinasiSerupaResult.value = Result.Error(response.message())
                }
            }

            override fun onFailure(call: Call<ResponseDestination>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
                destinasiSerupaResult.value = Result.Error("No Internet")
            }
        })
    }

    fun setNearby(lat : Float, lon: Float){
        nearbyResult.value = Result.Loading
//        val token = runBlocking { userPreference.getSession().first().token }
//        val bearerToken = "Bearer $token"
//        val response = apiService.getNearby(bearerToken, lat, lon)
        val response = apiService.getNearby()

        response.enqueue(object : Callback<ResponseDestination> {
            override fun onResponse(
                call: Call<ResponseDestination>,
                response: Response<ResponseDestination>
            ) {
                val listData = response.body()
                if (response.isSuccessful && listData != null){
                    nearbyResult.value = Result.Success(listData.listDestination)
                }else{
                    Log.e(TAG, "onFailure: ${response.message()}")
                    nearbyResult.value = Result.Error(response.message())
                }
            }

            override fun onFailure(call: Call<ResponseDestination>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
                nearbyResult.value = Result.Error("No Internet")
            }
        })
    }

    fun setRecommendation(){
        recommendationResult.value = Result.Loading
//        val token = runBlocking { userPreference.getSession().first().token }
//        val bearerToken = "Bearer $token"
//        val response = apiService.getRecommendation(bearerToken)
        val response = apiService.getRecommendation()

        response.enqueue(object : Callback<ResponseDestination> {
            override fun onResponse(
                call: Call<ResponseDestination>,
                response: Response<ResponseDestination>
            ) {
                val listData = response.body()
                if (response.isSuccessful && listData != null){
                    recommendationResult.value = Result.Success(listData.listDestination)
                }else{
                    Log.e(TAG, "onFailure: ${response.message()}")
                    recommendationResult.value = Result.Error(response.message())
                }
            }

            override fun onFailure(call: Call<ResponseDestination>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
                recommendationResult.value = Result.Error("No Internet")
            }
        })
    }

    fun setFavorite(){
        favoriteResult.value = Result.Loading
//        val token = runBlocking { userPreference.getSession().first().token }
//        val bearerToken = "Bearer $token"
//        val response = apiService.getRecommendation(bearerToken)
        val response = apiService.getFavorite()

        response.enqueue(object : Callback<ResponseDestination> {
            override fun onResponse(
                call: Call<ResponseDestination>,
                response: Response<ResponseDestination>
            ) {
                val listData = response.body()
                if (response.isSuccessful && listData != null){
                    favoriteResult.value = Result.Success(listData.listDestination)
                }else{
                    Log.e(TAG, "onFailure: ${response.message()}")
                    favoriteResult.value = Result.Error(response.message())
                }
            }

            override fun onFailure(call: Call<ResponseDestination>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
                favoriteResult.value = Result.Error("No Internet")
            }
        })
    }

    fun getDestinasiSerupa() = destinasiSerupaResult

    fun getFavorite() = favoriteResult

    fun getRecommendation() = recommendationResult

    fun getNearby() = nearbyResult
    companion object{
        private const val TAG = "DestinationRepository"
    }
}