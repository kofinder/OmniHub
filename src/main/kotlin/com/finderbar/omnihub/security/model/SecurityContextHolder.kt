package com.finderbar.omnihub.security.model

object SecurityContextHolder {

    private val context = ThreadLocal<SecurityContext>()

    fun set(ctx: SecurityContext) {
        context.set(ctx)
    }

    fun get(): SecurityContext? {
        return context.get()
    }

    fun clear() {
        context.remove()
    }
}