package com.capstone.destimate.data.remote.response


import com.google.gson.annotations.SerializedName

data class LoginResult(
    @SerializedName("age")
    val age: Int,
    @SerializedName("city")
    val city: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("photoUrl")
    val photoUrl: String,
    @SerializedName("preference")
    val preference: Boolean,
    @SerializedName("province")
    val province: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("userId")
    val userId: String
)