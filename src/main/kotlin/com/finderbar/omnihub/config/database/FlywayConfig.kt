package com.finderbar.omnihub.config.database

import org.flywaydb.core.Flyway
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class FlywayConfig {
    @Bean(initMethod = "migrate")
    fun flyway(@Qualifier("masterDataSource") dataSource: DataSource): Flyway {
        return Flyway.configure()
            .dataSource(dataSource)
            .schemas("core", "iam")
            .defaultSchema("core")
            .locations(
                "classpath:db/migration/db/core",
                "classpath:db/migration/db/iam",
                "classpath:db/migration/seed/core",
                "classpath:db/migration/seed/iam"
            )
            .baselineOnMigrate(true)
            .baselineVersion("1")
            .ignoreMigrationPatterns("*")
            .load()
    }
}