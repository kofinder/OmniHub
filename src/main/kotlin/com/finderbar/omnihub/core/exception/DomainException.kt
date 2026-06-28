package com.finderbar.omnihub.core.exception

import org.springframework.http.HttpStatus

abstract class DomainException(
    val code: String,
    override val message: String,
    val httpStatus: HttpStatus,
    val details: Map<String, Any>? = null
) : RuntimeException(message)