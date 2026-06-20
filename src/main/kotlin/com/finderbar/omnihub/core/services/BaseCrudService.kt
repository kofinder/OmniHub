package com.finderbar.omnihub.core.services

import com.finderbar.omnihub.annotations.MasterTransaction
import com.finderbar.omnihub.core.entity.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

abstract class BaseCrudService<
    ENTITY : BaseEntity,
    REPOSITORY : JpaRepository<ENTITY, UUID>
>(
    repository: REPOSITORY
) : BaseQueryService<ENTITY, REPOSITORY>(repository) {

    @MasterTransaction
    open fun create(entity: ENTITY): ENTITY {
        return repository.save(entity)
    }

    @MasterTransaction
    open fun update(entity: ENTITY): ENTITY {
        return repository.save(entity)
    }

    @MasterTransaction
    open fun delete(entity: ENTITY) {
        repository.delete(entity)
    }

    @MasterTransaction
    open fun deleteById(id: UUID) {
        repository.deleteById(id)
    }
}