package com.finderbar.omnihub.core.services
import com.finderbar.omnihub.annotations.ReadOnlyTransaction
import com.finderbar.omnihub.core.entity.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

abstract class BaseQueryService<
    ENTITY : BaseEntity,
    REPOSITORY : JpaRepository<ENTITY, UUID>
> (
    protected val repository: REPOSITORY
) {

    @ReadOnlyTransaction
    open fun findAll(): List<ENTITY> {
        return repository.findAll()
    }

    @ReadOnlyTransaction
    open fun findById(id: UUID): ENTITY? {
        return repository.findById(id).orElse(null)
    }

    @ReadOnlyTransaction
    open fun exists(id: UUID): Boolean {
        return repository.existsById(id)
    }
}