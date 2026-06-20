package com.finderbar.omnihub.core.mapper


interface CreateMapper<C, E> {
    fun toEntity(request: C): E
}
