package com.finderbar.omnihub.core.exception

import org.springframework.http.HttpStatus

class ConflictException(
    message: String
) : DomainException(
    code = "CONFLICT",
    message = message,
    httpStatus = HttpStatus.CONFLICT
)