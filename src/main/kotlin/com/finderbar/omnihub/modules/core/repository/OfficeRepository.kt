package com.finderbar.omnihub.modules.core.repository

import com.finderbar.omnihub.core.repository.BaseRepository
import com.finderbar.omnihub.modules.core.entity.OfficeEntity
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface OfficeRepository : BaseRepository<OfficeEntity, UUID> {
    fun countByCompanyId(companyId: UUID): Long
}