package com.finderbar.omnihub.core.facade

import com.finderbar.omnihub.core.api.ApiResponse

abstract class AbstractCrudFacade<
    ID,
    MODEL,
    SEARCH,
    CREATE,
    UPDATE
> : BaseCrudFacade<ID, MODEL, SEARCH, CREATE, UPDATE> {

    protected fun <T> success(data: T): ApiResponse<T> =
        ApiResponse.success(data)

    protected fun error(message: String): ApiResponse<Nothing> =
        ApiResponse.error(message = message)

}