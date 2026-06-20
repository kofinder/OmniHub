package com.finderbar.omnihub.core.mapper


interface ResponseMapper<E, R> {

    fun toResponse(entity: E): R

    fun toResponseList(entities: List<E>): List<R> = entities.map(::toResponse)
}
