package com.finderbar.omnihub.modules.core.repository

import com.finderbar.omnihub.core.repository.BaseRepository
import com.finderbar.omnihub.modules.core.entity.BranchEntity
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface BranchRepository : BaseRepository<BranchEntity, UUID> {
    fun existsByCode(code: String): Boolean

    fun findByCode(code: String): BranchEntity?
}

