package com.finderbar.omnihub.core.extenstion
fun <T> Iterable<T>.forEachIf(
    predicate: (T) -> Boolean,
    action: (T) -> Unit
) {
    filter(predicate).forEach(action)
}

fun <T> Iterable<T>.mapToMutableList(
    mapper: (T) -> T
): MutableList<T> =
    map(mapper).toMutableList()

fun <T> Iterable<T>.joinComma(): String =
    joinToString(",")

fun <T> Iterable<T>.joinNewLine(): String =
    joinToString("\n")

fun <T> Iterable<T>.isNotEmpty(): Boolean =
    iterator().hasNext()

fun <T> Iterable<T>.firstOrThrow(
    message: String = "Element not found."
): T =
    firstOrNull() ?: throw NoSuchElementException(message)