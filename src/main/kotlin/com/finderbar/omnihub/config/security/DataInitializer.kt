package com.finderbar.omnihub.config.security

import com.finderbar.omnihub.modules.iam.repository.UserAccountRepository
import jakarta.transaction.Transactional
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataInitializer {

    @Bean
    @Transactional
    fun initData(
        userAccountRepository: UserAccountRepository,
//        roleRepository: RoleRepository,
//        permissionRepository: PermissionRepository,
//        departmentRepository: DepartmentRepository
    ) = CommandLineRunner {
    }
}