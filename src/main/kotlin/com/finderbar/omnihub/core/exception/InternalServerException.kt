package com.finderbar.omnihub.core.exception

import org.springframework.http.HttpStatus


class InternalServerException(
    message: String = "Unexpected server error"
) : DomainException(
    code = "INTERNAL_ERROR",
    message = message,
    httpStatus = HttpStatus.INTERNAL_SERVER_ERROR
)