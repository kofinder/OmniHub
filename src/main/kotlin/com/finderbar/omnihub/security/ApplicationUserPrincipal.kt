package com.finderbar.omnihub.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.UUID


class ApplicationUserPrincipal(
    val id: UUID,
    private val username: String,
    private val password: String,
    private val enabled: Boolean,
    private val authorities: Collection<GrantedAuthority>
) : UserDetails {

    override fun getAuthorities() = authorities

    override fun getPassword() = password

    override fun getUsername() = username

    override fun isEnabled() = enabled
}