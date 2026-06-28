package com.finderbar.omnihub.core.mapper


interface ModelMapper<E, R> {

    fun toModel(entity: E): R

}
