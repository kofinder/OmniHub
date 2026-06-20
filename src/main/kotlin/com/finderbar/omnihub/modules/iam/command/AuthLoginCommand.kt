package com.finderbar.omnihub.modules.iam.command

data class AuthLoginCommand(
    val username: String,
    val password: String
)