package com.finderbar.omnihub.modules.business

import com.finderbar.omnihub.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table

@Entity
@Table(
    schema = "business",
    name = "business"
)
class BusinessEntity(

    @Column(name = "name", nullable = false)
    var name: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "business_type", nullable = false)
    var businessType: BusinessType,

    @Column(name = "email")
    var email: String? = null,

    @Column(name = "phone")
    var phone: String? = null,

    @Column(name = "address", columnDefinition = "TEXT")
    var address: String? = null,

    @Column(name = "active", nullable = false)
    var active: Boolean = true

) : BaseEntity()