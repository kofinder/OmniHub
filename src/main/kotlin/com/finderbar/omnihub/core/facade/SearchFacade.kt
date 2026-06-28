package com.finderbar.omnihub.core.facade
import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse

interface SearchFacade<SEARCH, MODEL> {
    fun search(criteria: SEARCH): ApiResponse<PageResponse<MODEL>>
}