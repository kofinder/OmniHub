package com.finderbar.omnihub.core.extenstion

import java.math.BigDecimal
import java.math.RoundingMode

fun BigDecimal.money(): BigDecimal =
    setScale(2, RoundingMode.HALF_UP)

fun BigDecimal.percentage(): BigDecimal =
    setScale(4, RoundingMode.HALF_UP)

fun BigDecimal?.orZero(): BigDecimal =
    this ?: BigDecimal.ZERO