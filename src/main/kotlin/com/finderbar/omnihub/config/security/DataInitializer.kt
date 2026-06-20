package com.finderbar.omnihub.config.security

import com.finderbar.omnihub.modules.iam.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataInitializer {

    @Bean
    @Transactional
    fun initData(
        userRepository: UserRepository,
//        roleRepository: RoleRepository,
//        permissionRepository: PermissionRepository,
//        departmentRepository: DepartmentRepository
    ) = CommandLineRunner {
    }
}