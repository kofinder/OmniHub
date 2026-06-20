package com.finderbar.omnihub.modules.iam.entity
import com.finderbar.omnihub.core.entity.BaseEntity
import com.finderbar.omnihub.modules.core.entity.EmployeeEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import java.time.LocalDateTime

@Entity
@Table(
    schema = "iam",
    name = "user_account",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_user_account_username",
            columnNames = ["username"]
        )
    ]
)
class UserAccountEntity(

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "employee_id",
        nullable = false,
        foreignKey = ForeignKey(
            name = "fk_user_account_employee"
        )
    )
    var employee: EmployeeEntity,

    @Column(
        nullable = false,
        length = 100
    )
    var username: String,

    @Column(
        name = "password_hash",
        nullable = false,
        length = 255
    )
    var passwordHash: String,

    @Column(nullable = false)
    var enabled: Boolean = true,

    @Column(
        name = "account_non_expired",
        nullable = false
    )
    var accountNonExpired: Boolean = true,

    @Column(
        name = "account_non_locked",
        nullable = false
    )
    var accountNonLocked: Boolean = true,

    @Column(name = "token_version", nullable = false)
    var tokenVersion: Int = 0,

    @Column(
        name = "credentials_non_expired",
        nullable = false
    )
    var credentialsNonExpired: Boolean = true,

    @Column(
        name = "failed_login_attempts",
        nullable = false
    )
    var failedLoginAttempts: Int = 0,

    @Column(name = "last_login_at")
    var lastLoginAt: LocalDateTime? = null,

    @Column(name = "password_changed_at")
    var passwordChangedAt: LocalDateTime? = null,

    @Column(name = "locked_until")
    var lockedUntil: LocalDateTime? = null
) : BaseEntity() {
    fun increaseFailedLoginAttempts() {
        failedLoginAttempts++
    }

    fun resetFailedLoginAttempts() {
        failedLoginAttempts = 0
    }

    fun lock(minutes: Long = 10) {
        accountNonLocked = false
        lockedUntil = LocalDateTime.now().plusMinutes(minutes)
    }

    fun unlock() {
        accountNonLocked = true
        lockedUntil = null
        failedLoginAttempts = 0
    }

    fun increaseTokenVersion() {
        tokenVersion++
    }
}