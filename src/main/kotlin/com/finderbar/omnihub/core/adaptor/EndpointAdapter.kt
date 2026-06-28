package com.finderbar.omnihub.core.adaptor

interface EndpointAdapter<I, O> {
    fun handle(input: I): O
}