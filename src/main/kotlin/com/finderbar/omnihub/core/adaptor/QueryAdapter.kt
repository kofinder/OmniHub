package com.finderbar.omnihub.core.adaptor

interface Query

interface QueryAdapter<Q : Query, R> {
    fun execute(query: Q): R
}