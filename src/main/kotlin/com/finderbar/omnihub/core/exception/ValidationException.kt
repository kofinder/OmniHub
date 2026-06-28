package com.finderbar.omnihub.core.exception

import org.springframework.http.HttpStatus


class ValidationException(
    message: String,
    val fields: Map<String, String>? = null
) : DomainException(
    code = "VALIDATION_ERROR",
    message = message,
    httpStatus = HttpStatus.BAD_REQUEST,
    details = fields
)