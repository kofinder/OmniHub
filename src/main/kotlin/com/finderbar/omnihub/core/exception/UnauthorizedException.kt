package com.finderbar.omnihub.core.exception

import org.springframework.http.HttpStatus


class UnauthorizedException(
    message: String = "Unauthorized access"
) : DomainException(
    code = "UNAUTHORIZED",
    message = message,
    httpStatus = HttpStatus.UNAUTHORIZED
)