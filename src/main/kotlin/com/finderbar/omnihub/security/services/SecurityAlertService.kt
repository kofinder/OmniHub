package com.finderbar.omnihub.security.services

import com.finderbar.omnihub.modules.utility.SecurityEventType
import com.finderbar.omnihub.security.model.SecurityAlert
import org.springframework.stereotype.Service

@Service
class SecurityAlertService(
    private val securityAuditService: SecurityAuditService
) {

    fun send(alert: SecurityAlert) {

        // 1. LOG to audit table (important for traceability)
        securityAuditService.log(
            username = alert.username,
            eventType = SecurityEventType.SECURITY_ALERT,
            success = false,
            ip = alert.ip,
            details = "${alert.type} | ${alert.severity} | ${alert.message}"
        )

        // 2. Console log (for dev)
        println("🚨 SECURITY ALERT: $alert")

        // 3. Future integrations (optional placeholders)
        // emailService.send(alert)
        // telegramService.send(alert)
        // slackService.send(alert)
    }
}