package com.finderbar.omnihub.core.exception

import org.springframework.http.HttpStatus


class ExternalServiceException(
    service: String,
    message: String
) : DomainException(
    code = "EXTERNAL_SERVICE_ERROR",
    message = "Service '$service' failed: $message",
    httpStatus = HttpStatus.BAD_GATEWAY
)