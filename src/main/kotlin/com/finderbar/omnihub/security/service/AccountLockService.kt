package com.finderbar.omnihub.security.service
import org.springframework.stereotype.Service

@Service
class AccountLockService {

    fun isLocked(
        username: String
    ): Boolean {

        return false
    }

    fun recordFailure(
        username: String
    ) {

    }

    fun resetFailures(
        username: String
    ) {

    }
}