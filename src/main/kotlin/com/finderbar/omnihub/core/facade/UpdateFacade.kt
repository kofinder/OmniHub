package com.finderbar.omnihub.core.facade

import com.finderbar.omnihub.core.api.ApiResponse

interface UpdateFacade<ID, UPDATE, MODEL> {
    fun update(id: ID, command: UPDATE): ApiResponse<MODEL>
}
