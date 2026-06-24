package com.finderbar.omnihub.modules.core.repository

import com.finderbar.omnihub.modules.core.entity.CompanyEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID


@Repository
interface CompanyRepository : JpaRepository<CompanyEntity, UUID> {}