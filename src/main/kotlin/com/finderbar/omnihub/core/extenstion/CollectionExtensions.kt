package com.finderbar.omnihub.core.extenstion

fun <T> Collection<T>?.isNotNullOrEmpty(): Boolean =
    !this.isNullOrEmpty()

fun <T> Collection<T>?.orEmptyList(): List<T> =
    this?.toList() ?: emptyList()

fun <T> List<T>.secondOrNull(): T? =
    getOrNull(1)

fun <T> List<T>.thirdOrNull(): T? =
    getOrNull(2)