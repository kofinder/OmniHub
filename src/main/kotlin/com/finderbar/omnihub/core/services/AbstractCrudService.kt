package com.finderbar.omnihub.core.services

import com.finderbar.omnihub.annotations.MasterTransaction
import com.finderbar.omnihub.core.entity.BaseEntity
import com.finderbar.omnihub.core.repository.BaseRepository
import java.util.UUID

abstract class AbstractCrudService<
    ENTITY : BaseEntity,
    SEARCH,
    REPOSITORY : BaseRepository<ENTITY, UUID>
>(
    repository: REPOSITORY
) : AbstractQueryService<ENTITY, SEARCH, REPOSITORY>(repository) {

    @MasterTransaction
    open fun create(entity: ENTITY): ENTITY = repository.save(entity)

    @MasterTransaction
    open fun update(entity: ENTITY): ENTITY = repository.save(entity)

    @MasterTransaction
    open fun delete(entity: ENTITY) = repository.delete(entity)

    @MasterTransaction
    open fun deleteById(id: UUID) = repository.deleteById(id)
}