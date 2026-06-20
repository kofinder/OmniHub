package com.finderbar.omnihub.security.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class ApplicationUserPrincipal(

    val id: String,

    private val username: String,

    private val password: String,

    private val authorities: Collection<GrantedAuthority>,

    private val tokenVersion: Int = 0,

    private val accountNonExpired: Boolean = true,

    private val accountNonLocked: Boolean = true,

    private val credentialsNonExpired: Boolean = true,

    private val enabled: Boolean = true

) : UserDetails {
    override fun getAuthorities() = authorities

    override fun getPassword() = password

    override fun getUsername() = username

    override fun isAccountNonExpired(): Boolean = accountNonExpired

    override fun isAccountNonLocked(): Boolean = accountNonLocked

    override fun isCredentialsNonExpired(): Boolean = credentialsNonExpired

    override fun isEnabled(): Boolean = enabled
}