package com.finderbar.omnihub.core.aspect

import com.finderbar.omnihub.security.services.SecurityAuditService
import com.finderbar.omnihub.modules.utility.SecurityEventType
import com.finderbar.omnihub.security.model.RequestContext
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

@Aspect
@Component
class ApiAuditAspect(
    private val securityAuditService: SecurityAuditService
) {

    @Around("execution(* com.finderbar.omnihub..controller..*(..))")
    fun auditApi(joinPoint: ProceedingJoinPoint): Any? {

        val request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request

        val username = RequestContext.getUsername() ?: "anonymous"
        val ip = request.remoteAddr
        val path = request.requestURI

        val start = System.currentTimeMillis()

        return try {

            val result = joinPoint.proceed()

            securityAuditService.log(
                username = username,
                eventType = SecurityEventType.API_CALL,
                success = true,
                ip = ip,
                details = "SUCCESS: $path took ${System.currentTimeMillis() - start}ms"
            )

            result

        } catch (ex: Exception) {

            securityAuditService.log(
                username = username,
                eventType = SecurityEventType.API_ERROR,
                success = false,
                ip = ip,
                details = "ERROR: $path -> ${ex.message}"
            )

            throw ex
        }
    }
}

