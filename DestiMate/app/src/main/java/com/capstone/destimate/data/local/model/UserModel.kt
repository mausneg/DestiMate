package com.capstone.destimate.data.local.model

data class UserModel(
    var email: String,
    var name: String,
    var preferences: Boolean,
    var photoUrl: String,
    var token: String,
    var isLogin: Boolean,
)
