package com.finderbar.omnihub.security.service
import com.finderbar.omnihub.modules.iam.entity.UserEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails(
    private val user: UserEntity
) : UserDetails {

    override fun getAuthorities():
            Collection<GrantedAuthority> {

        return user.authorities.map {

            SimpleGrantedAuthority(
                it.authority.name
            )
        }
    }

    override fun getPassword(): String {
        return user.password
    }

    override fun getUsername(): String {
        return user.username
    }

    override fun isEnabled(): Boolean {
        return user.enabled
    }

    fun getUser(): UserEntity {
        return user
    }
}