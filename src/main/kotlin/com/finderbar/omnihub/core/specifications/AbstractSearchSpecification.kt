package com.finderbar.omnihub.core.specifications

import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.Expression
import jakarta.persistence.criteria.Path
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.springframework.data.jpa.domain.Specification
import java.time.LocalDate


abstract class AbstractSearchSpecification<T : Any> {

    protected abstract fun buildPredicates(
        root: Root<T>,
        cb: CriteriaBuilder
    ): MutableList<Predicate?>

    fun build(): Specification<T> {
        return Specification { root, _, cb ->
            cb.and(*buildPredicates(root, cb).toTypedArray())
        }
    }

    protected fun <V> addEqual(
        predicates: MutableList<Predicate>,
        cb: CriteriaBuilder,
        path: Path<V>,
        value: V?
    ) {
        value?.let {predicates += cb.equal(path, it)}
    }

    protected fun addKeywordSearch(
        predicates: MutableList<Predicate>,
        cb: CriteriaBuilder,
        keyword: String?,
        vararg expressions: Expression<String>
    ) {

        if (keyword.isNullOrBlank()) {
            return
        }

        val value = "%${keyword.lowercase()}%"

        predicates += cb.or(
            *expressions.map {
                cb.like(
                    cb.lower(it),
                    value
                )
            }.toTypedArray()
        )
    }

    protected fun addFromDate(
        predicates: MutableList<Predicate>,
        cb: CriteriaBuilder,
        path: Path<LocalDate>,
        value: LocalDate?
    ) {
        value?.let {
            predicates += cb.greaterThanOrEqualTo(
                path,
                it
            )
        }
    }

    protected fun addToDate(
        predicates: MutableList<Predicate>,
        cb: CriteriaBuilder,
        path: Path<LocalDate>,
        value: LocalDate?
    ) {
        value?.let {
            predicates += cb.lessThanOrEqualTo(
                path,
                it
            )
        }
    }
}