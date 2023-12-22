package com.capstone.destimate.data.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseDestination(
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("listDestination")
    val listDestination: List<Destination>,
    @SerializedName("message")
    val message: String
)
