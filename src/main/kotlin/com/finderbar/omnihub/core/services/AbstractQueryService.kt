package com.finderbar.omnihub.core.services
import com.finderbar.omnihub.annotations.ReadOnlyTransaction
import com.finderbar.omnihub.core.entity.BaseEntity
import com.finderbar.omnihub.core.pageable.AbstractPageSearchQuery
import com.finderbar.omnihub.core.pageable.PageableFactory
import com.finderbar.omnihub.core.repository.BaseRepository

import java.util.UUID

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification

abstract class AbstractQueryService<
    ENTITY : BaseEntity,
    SEARCH,
    REPOSITORY : BaseRepository<ENTITY, UUID>
>(
    protected val repository: REPOSITORY
) {

    protected abstract fun toSpecification(criteria: SEARCH): Specification<ENTITY>

    protected open fun toPageable(criteria: SEARCH): Pageable = PageableFactory.create(criteria as AbstractPageSearchQuery)

    @ReadOnlyTransaction
    open fun findAll(): List<ENTITY> = repository.findAll()

    @ReadOnlyTransaction
    open fun findById(id: UUID): ENTITY? = repository.findById(id).orElse(null)

    @ReadOnlyTransaction
    open fun exists(id: UUID): Boolean = repository.existsById(id)

    @ReadOnlyTransaction
    open fun search(criteria: SEARCH): Page<ENTITY> {
        return repository.findAll(
            toSpecification(criteria),
            toPageable(criteria)
        )
    }
}
