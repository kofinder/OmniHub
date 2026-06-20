package com.finderbar.omnihub.security.services

import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class LoginRateLimitService {

    private val attempts = ConcurrentHashMap<String, MutableList<Long>>()
    private val blocked = ConcurrentHashMap<String, Long>()

    private val MAX_ATTEMPTS = 5
    private val WINDOW_MS = 10 * 60 * 1000L // 10 minutes
    private val BLOCK_MS = 10 * 60 * 1000L   // 10 minutes block

    fun isBlocked(username: String): Boolean {

        val blockUntil = blocked[username] ?: return false

        if (System.currentTimeMillis() > blockUntil) {
            blocked.remove(username)
            return false
        }

        return true
    }

    fun recordFailure(username: String) {

        val now = System.currentTimeMillis()

        val list = attempts.getOrPut(username) { mutableListOf() }

        list.add(now)

        // remove old attempts outside window
        list.removeIf { it < now - WINDOW_MS }

        if (list.size >= MAX_ATTEMPTS) {
            blocked[username] = now + BLOCK_MS
            attempts.remove(username)
        }
    }

    fun reset(username: String) {
        attempts.remove(username)
        blocked.remove(username)
    }
}