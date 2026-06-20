package com.finderbar.omnihub.core.mapper


interface UpdateMapper<U, E> {
    fun updateEntity(entity: E, request: U): E
}