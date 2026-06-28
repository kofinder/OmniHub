package com.finderbar.omnihub.core.extenstion

import org.springframework.data.domain.Page

fun <T : Any, R : Any> Page<T>.mapContent(
    mapper: (T) -> R
): Page<R> =
    map(mapper)