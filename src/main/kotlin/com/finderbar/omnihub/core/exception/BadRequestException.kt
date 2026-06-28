package com.finderbar.omnihub.core.exception

import org.springframework.http.HttpStatus

class BadRequestException(
    message: String
) : DomainException(
    code = "BAD_REQUEST",
    message = message,
    httpStatus = HttpStatus.BAD_REQUEST
)