package com.finderbar.omnihub.core.decorator

import org.springframework.data.domain.Page

abstract class AbstractDecorator<T : Any> {

    abstract fun decorate(target: T): T

    open fun decorateAll(targets: List<T>): List<T> {
        targets.forEach(::decorate)
        return targets
    }

    open fun decoratePage(page: Page<T>): Page<T> {
        decorateAll(page.content)
        return page
    }
}