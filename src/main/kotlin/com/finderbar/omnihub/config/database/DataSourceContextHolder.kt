package com.finderbar.omnihub.config.database

object DataSourceContextHolder {
    private val context = ThreadLocal<DataSourceType>()

    fun set(type: DataSourceType) {
        context.set(type)
    }

    fun get(): DataSourceType {
        return context.get() ?: DataSourceType.MASTER
    }

    fun clear() {
        context.remove()
    }
}