package com.finderbar.omnihub.config.audit


import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
class JpaAuditConfig