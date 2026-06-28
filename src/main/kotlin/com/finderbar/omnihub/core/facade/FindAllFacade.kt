package com.finderbar.omnihub.core.facade

import com.finderbar.omnihub.core.api.ApiResponse


interface FindAllFacade<MODEL> {
    fun findAll(): ApiResponse<List<MODEL>>
}