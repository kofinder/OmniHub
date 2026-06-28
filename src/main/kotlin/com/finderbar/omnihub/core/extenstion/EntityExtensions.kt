package com.finderbar.omnihub.core.extenstion

import com.finderbar.omnihub.core.entity.BaseEntity

fun BaseEntity.isNew(): Boolean =
    id == null