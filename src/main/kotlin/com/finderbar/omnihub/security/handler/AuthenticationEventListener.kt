package com.finderbar.omnihub.security.handler

import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.context.event.EventListener
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent
import org.springframework.security.authentication.event.AuthenticationSuccessEvent
import org.springframework.stereotype.Component

@Component
class AuthenticationEventListener {

    private val logger =
        LoggerFactory.getLogger(
            AuthenticationEventListener::class.java
        )

    @EventListener
    fun onAuthenticationSuccess(
        event: AuthenticationSuccessEvent
    ) {

        try {

            val authentication =
                event.authentication

            logger.info(
                "Authentication success user={}",
                authentication.name
            )

        } finally {

            MDC.clear()
        }
    }

    @EventListener
    fun onAuthenticationFailure(
        event: AbstractAuthenticationFailureEvent
    ) {

        try {

            val authentication =
                event.authentication

            logger.warn(
                "Authentication failure user={} reason={}",
                authentication.name,
                event.exception.message
            )

        } finally {

            MDC.clear()
        }
    }
}