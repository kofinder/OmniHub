package com.finderbar.omnihub.security.model

object RequestContext {

    private val usernameHolder = ThreadLocal<String>()
    private val requestIdHolder = ThreadLocal<String>()

    fun setUsername(username: String) {
        usernameHolder.set(username)
    }

    fun getUsername(): String? = usernameHolder.get()

    fun setRequestId(id: String) {
        requestIdHolder.set(id)
    }

    fun getRequestId(): String? = requestIdHolder.get()

    fun clear() {
        usernameHolder.remove()
        requestIdHolder.remove()
    }
}