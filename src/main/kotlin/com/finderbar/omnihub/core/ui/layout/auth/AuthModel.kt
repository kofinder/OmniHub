package com.finderbar.omnihub.core.ui.layout.auth

data class AuthModel(
    var isLoading: Boolean = false,
    var isLoggedIn: Boolean = false,
    var errorMessage: String? = null
)