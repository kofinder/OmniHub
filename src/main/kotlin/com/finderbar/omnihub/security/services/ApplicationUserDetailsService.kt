package com.finderbar.omnihub.security.services

import com.finderbar.omnihub.modules.iam.repository.PermissionRepository
import com.finderbar.omnihub.modules.iam.repository.RoleRepository
import com.finderbar.omnihub.modules.iam.repository.UserAccountRepository
import com.finderbar.omnihub.security.model.ApplicationUserPrincipal
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class ApplicationUserDetailsService(
    private val userRepo: UserAccountRepository,
    private val roleRepo: RoleRepository,
    private val permissionRepo: PermissionRepository
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {

        val user = userRepo.findByUsername(username)
            ?: throw UsernameNotFoundException("User not found")

        val roles = roleRepo.findRolesByUserId(user.id!!)

        val permissions = permissionRepo.findPermissionsByUserId(user.id!!)

        val authorities = mutableSetOf<GrantedAuthority>()

        // ROLE_
        roles.forEach {
            authorities.add(SimpleGrantedAuthority("ROLE_${it.code}"))
        }

        // permissions
        permissions.forEach {
            authorities.add(SimpleGrantedAuthority(it.code))
        }

        return ApplicationUserPrincipal(
            id = user.id.toString(),
            username = user.username,
            password = user.passwordHash,
            authorities = authorities
        )
    }
}