package com.finderbar.omnihub.modules.iam.command

data class AuthRegisterCommand(
    val username: String,
    val password: String
)