package com.finderbar.omnihub.modules.core.repository


import com.finderbar.omnihub.core.repository.BaseRepository
import com.finderbar.omnihub.modules.core.entity.BusinessEntity
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface BusinessRepository : BaseRepository<BusinessEntity, UUID> {}