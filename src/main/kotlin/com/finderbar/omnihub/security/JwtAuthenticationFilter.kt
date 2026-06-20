package com.finderbar.omnihub.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val jwtTokenManager: JwtTokenManager,
    private val userDetailsService: ApplicationUserDetailsService
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain
    ) {

        val authHeader = request.getHeader("Authorization")

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            chain.doFilter(request, response)
            return
        }

        val token = authHeader.substring(7)

        if (!jwtTokenManager.validate(token)) {
            chain.doFilter(request, response)
            return
        }

        val username = jwtTokenManager.extractUsername(token)

        if (SecurityContextHolder.getContext().authentication == null) {

            val user = userDetailsService.loadUserByUsername(username)

            val auth = UsernamePasswordAuthenticationToken(
                user,
                null,
                user.authorities
            )

            auth.details =
                WebAuthenticationDetailsSource().buildDetails(request)

            SecurityContextHolder.getContext().authentication = auth
        }

        chain.doFilter(request, response)
    }
}