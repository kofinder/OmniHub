package com.finderbar.omnihub.core.mapper

interface QueryMapper<PROJECTION, MODEL> {
    fun toModel(projection: PROJECTION): MODEL
}