package com.finderbar.omnihub.core.exception

import org.springframework.http.HttpStatus


class ForbiddenException(
    message: String = "You do not have permission to perform this action"
) : DomainException(
    code = "FORBIDDEN",
    message = message,
    httpStatus = HttpStatus.FORBIDDEN
)