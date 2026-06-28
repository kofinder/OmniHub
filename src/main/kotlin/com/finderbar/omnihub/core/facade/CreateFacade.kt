package com.finderbar.omnihub.core.facade

import com.finderbar.omnihub.core.api.ApiResponse


interface CreateFacade<CREATE, MODEL> {
    fun create(command: CREATE): ApiResponse<MODEL>
}
