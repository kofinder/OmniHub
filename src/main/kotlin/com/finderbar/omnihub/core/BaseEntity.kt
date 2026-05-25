package com.finderbar.omnihub.core
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID


@MappedSuperclass
abstract class BaseEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    open var id: UUID? = null,

    @Version
    open var version: Long? = null,

    @Column(name = "created_at", nullable = false)
    open var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    open var updatedAt: LocalDateTime = LocalDateTime.now()
)