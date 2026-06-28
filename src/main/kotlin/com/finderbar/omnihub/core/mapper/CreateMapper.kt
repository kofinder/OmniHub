package com.finderbar.omnihub.core.mapper


interface CreateMapper<C, E> {
    fun toEntity(model: C): E
}
