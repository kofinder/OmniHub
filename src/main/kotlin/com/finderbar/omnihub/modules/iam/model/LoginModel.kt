package com.finderbar.omnihub.modules.iam.model

data class LoginModel(
    val userId: String,
    val username: String,
    val accessToken: String,
    val refreshToken: String,
)