package com.capstone.destimate.data.local.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DestinationModel(
    val category: String,
    val city: String,
    val description: String,
    val lat: Double,
    val long: Double,
    val photoUrl: String,
    val placeId: Int,
    val placeName: String,
    val price: Int,
    val rating: Double,
    val ratingCount: Int
): Parcelable