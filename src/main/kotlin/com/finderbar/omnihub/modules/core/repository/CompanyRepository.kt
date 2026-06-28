package com.finderbar.omnihub.modules.core.repository

import com.finderbar.omnihub.core.repository.BaseRepository
import com.finderbar.omnihub.modules.core.entity.CompanyEntity
import org.springframework.stereotype.Repository
import java.util.UUID


@Repository
interface CompanyRepository : BaseRepository<CompanyEntity, UUID> {
    fun existsByCode(code: String): Boolean

    fun findByCode(code: String): CompanyEntity?
}
