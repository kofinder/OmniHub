package com.finderbar.omnihub.security.service

import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service

@Service
class PermissionEvaluatorService {

    fun hasAuthority(
        authentication: Authentication,
        authority: String
    ): Boolean {

        return authentication.authorities.any {
            it.authority == authority
        }
    }
}