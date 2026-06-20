package com.finderbar.omnihub.security

import com.finderbar.omnihub.modules.iam.repository.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class ApplicationUserDetailsService(
    private val userRepository: UserRepository,
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)
                ?: throw UsernameNotFoundException(username)
        val authorities = user.roles.map { SimpleGrantedAuthority(it.code) }
        return ApplicationUserPrincipal(
            id = user.id!!,
            username = user.username,
            password = user.password!!,
            enabled = user.enabled,
            authorities
        )
    }
}