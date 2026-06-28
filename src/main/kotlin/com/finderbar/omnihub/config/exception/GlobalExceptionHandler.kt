package com.finderbar.omnihub.config.exception

import com.finderbar.omnihub.core.exception.DomainException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(DomainException::class)
    fun handle(ex: DomainException, request: HttpServletRequest): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(ex.httpStatus)
            .body(
                ErrorResponse(
                    code = ex.code,
                    message = ex.message,
                    path = request.requestURI,
                    details = ex.details
                )
            )
    }

    @ExceptionHandler(Exception::class)
    fun handle(ex: Exception, request: HttpServletRequest): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(
                ErrorResponse(
                    code = "UNHANDLED_ERROR",
                    message = ex.message ?: "Unexpected error",
                    path = request.requestURI
                )
            )
    }
}