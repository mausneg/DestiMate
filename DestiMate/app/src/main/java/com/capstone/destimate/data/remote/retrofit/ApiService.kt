package com.capstone.destimate.data.remote.retrofit

import com.capstone.destimate.data.remote.response.ResponseDestination
import com.capstone.destimate.data.remote.response.ResponseLogin
import com.capstone.destimate.data.remote.response.ResponseSignUp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("favorite")
    fun getFavorite(
//        @Header("Authorization") token: String
    ): Call<ResponseDestination>

    @GET("favorite")
    fun getDestinasiSerupa(
//        @Header("Authorization") token: String,
//        @Query("id_place") id_place : String
    ): Call<ResponseDestination>

    @GET("recommendation")
    fun getRecommendation(
//        @Header("Authorization") token: String
    ): Call<ResponseDestination>

    @GET("nearby-user")
    fun getNearby(
//    @Header("Authorization") token: String
//    @Query("lat") lat : Float,
//    @Query("lon") lon : Float
    ): Call<ResponseDestination>

//    @FormUrlEncoded
    @POST("login")
    fun login(
//        @Field("email") email: String,
//        @Field("password") password: String
    ): Call<ResponseLogin>

//    @Multipart
    @POST("signup")
    fun signUp(
//        @Header("Authorization") token: String,
//        @Part image: MultipartBody.Part,
//        @Part("nama") nama: RequestBody,
//        @Part("email") email: RequestBody,
//        @Part("age") age: RequestBody,
//        @Part("password") password: RequestBody,
//        @Part("birthday") birthday: RequestBody,
    ): Call<ResponseSignUp>
}