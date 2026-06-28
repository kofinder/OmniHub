package com.finderbar.omnihub.core.extenstion


fun Boolean?.orFalse(): Boolean =
    this ?: false

fun Boolean?.orTrue(): Boolean =
    this ?: true