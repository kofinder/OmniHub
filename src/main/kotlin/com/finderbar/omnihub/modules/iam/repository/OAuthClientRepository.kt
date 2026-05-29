package com.finderbar.omnihub.modules.iam.repository

import com.finderbar.omnihub.modules.iam.entity.OAuthClientEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OAuthClientRepository : JpaRepository<OAuthClientEntity, UUID> {

    fun findByClientId(
        clientId: String
    ): OAuthClientEntity?
}