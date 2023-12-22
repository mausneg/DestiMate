package com.capstone.destimate.data.remote.response

import com.google.gson.annotations.SerializedName

data class Destination(
    @SerializedName("category")
    val category: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("long")
    val long: Double,
    @SerializedName("photoUrl")
    val photoUrl: String,
    @SerializedName("place_id")
    val placeId: Int,
    @SerializedName("place_name")
    val placeName: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("rating_count")
    val ratingCount: Int
)
