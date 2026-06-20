package com.finderbar.omnihub.core.api

data class ApiResponse<T>(
    val success: Boolean,
    val message: String,
    val result: T? = null
) {
    companion object {

        fun <T> success(
            result: T,
            message: String = "Success"
        ): ApiResponse<T> =
            ApiResponse(
                success = true,
                message = message,
                result = result
            )

        fun success(
            message: String
        ): ApiResponse<Unit> =
            ApiResponse(
                success = true,
                message = message
            )

        fun error(
            message: String
        ): ApiResponse<Unit> =
            ApiResponse(
                success = false,
                message = message
            )

        fun ok(message: String): ApiResponse<Unit> = ApiResponse(
            success = false,
            message = message
        )
    }

}