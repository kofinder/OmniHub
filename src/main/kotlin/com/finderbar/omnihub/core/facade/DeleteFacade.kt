package com.finderbar.omnihub.core.facade

interface DeleteFacade<ID> {
    fun delete(id: ID)
}