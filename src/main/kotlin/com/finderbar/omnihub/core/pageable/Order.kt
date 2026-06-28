package com.finderbar.omnihub.core.pageable


data class Order(
    val name: String = "createdAt",
    val direction: OrderDirection = OrderDirection.DESC
)