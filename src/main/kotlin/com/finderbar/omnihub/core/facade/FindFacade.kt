package com.finderbar.omnihub.core.facade
import com.finderbar.omnihub.core.api.ApiResponse

interface FindFacade<ID, MODEL> {
    fun find(id: ID): ApiResponse<MODEL>
}