package com.finderbar.omnihub.core.adaptor

interface Command

interface CommandAdapter<C : Command, R> {
    fun execute(command: C): R
}
