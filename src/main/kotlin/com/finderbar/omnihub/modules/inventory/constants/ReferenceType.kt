package com.finderbar.omnihub.modules.inventory.constants

enum class ReferenceType {

    // Purchasing
    PURCHASE_ORDER,
    PURCHASE_RECEIPT,
    PURCHASE_RETURN,

    // Sales
    SALES_ORDER,
    SALES_DELIVERY,
    SALES_RETURN,

    // Inventory
    STOCK_ADJUSTMENT,
    STOCK_TRANSFER,
    STOCK_COUNT,

    // Manufacturing
    PRODUCTION_ORDER,
    PRODUCTION_CONSUMPTION,
    PRODUCTION_OUTPUT,

    // Warehouse
    GOODS_RECEIPT,
    GOODS_ISSUE,

    // Internal
    OPENING_BALANCE,
    CYCLE_COUNT,
    DAMAGE,
    SCRAP,
    LOST,
    FOUND,

    // Customer/Vendor
    CUSTOMER_RETURN,
    VENDOR_RETURN,

    // Manual
    MANUAL_ADJUSTMENT,

    // System
    SYSTEM
}