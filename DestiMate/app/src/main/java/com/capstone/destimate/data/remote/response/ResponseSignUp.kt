package com.capstone.destimate.data.remote.response


import com.google.gson.annotations.SerializedName

data class ResponseSignUp(
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("message")
    val message: String
)