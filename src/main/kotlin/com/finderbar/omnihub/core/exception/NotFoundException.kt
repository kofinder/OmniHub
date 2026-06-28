package com.finderbar.omnihub.core.exception

import org.springframework.http.HttpStatus


class NotFoundException(
    entity: String,
    id: Any
) : DomainException(
    code = "NOT_FOUND",
    message = "$entity with id '$id' was not found",
    httpStatus = HttpStatus.NOT_FOUND
)