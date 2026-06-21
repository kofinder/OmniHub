package com.finderbar.omnihub.config.database

import com.zaxxer.hikari.HikariDataSource
import jakarta.persistence.EntityManagerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.autoconfigure.DataSourceProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.transaction.PlatformTransactionManager

import javax.sql.DataSource

@Configuration
class DatabaseConfig {

    // ==========================
    // MASTER
    // ==========================

    @Bean
    @ConfigurationProperties("spring.datasource.master")
    fun masterDataSourceProperties(): DataSourceProperties {
        return DataSourceProperties()
    }

    @Bean(name = ["masterDataSource"])
    fun masterDataSource(): DataSource {

        return masterDataSourceProperties()
            .initializeDataSourceBuilder()
            .type(HikariDataSource::class.java)
            .build()
    }

    // ==========================
    // SLAVE
    // ==========================

    @Bean
    @ConfigurationProperties("spring.datasource.slave")
    fun slaveDataSourceProperties(): DataSourceProperties {
        return DataSourceProperties()
    }

    @Bean(name = ["slaveDataSource"])
    fun slaveDataSource(): DataSource {

        return slaveDataSourceProperties()
            .initializeDataSourceBuilder()
            .type(HikariDataSource::class.java)
            .build()
    }

    // ==========================
    // ROUTING DATASOURCE
    // ==========================

    @Primary
    @Bean(name = ["routingDataSource"])
    fun routingDataSource(

        @Qualifier("masterDataSource")
        master: DataSource,

        @Qualifier("slaveDataSource")
        slave: DataSource

    ): DataSource {

        val routing = ReplicationRoutingDataSource()

        routing.setTargetDataSources(
            mapOf(
                DataSourceType.MASTER to master,
                DataSourceType.SLAVE to slave
            )
        )

        routing.setDefaultTargetDataSource(master)

        routing.afterPropertiesSet()

        return routing
    }

    // ==========================
    // TRANSACTION MANAGER
    // ==========================

    @Bean
    fun transactionManager(
        entityManagerFactory: EntityManagerFactory
    ): PlatformTransactionManager {

        return JpaTransactionManager(entityManagerFactory)
    }
}
//
//import com.zaxxer.hikari.HikariDataSource
//import jakarta.persistence.EntityManagerFactory
//import org.springframework.boot.context.properties.ConfigurationProperties
//import org.springframework.boot.jdbc.autoconfigure.DataSourceProperties
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.context.annotation.Primary
//import org.springframework.orm.jpa.JpaTransactionManager
//import org.springframework.transaction.PlatformTransactionManager
//import javax.sql.DataSource
//
//@Configuration
//class DatabaseConfig {
//
//    // -----------------------------
//    // MASTER
//    // -----------------------------
//
//    @Bean
//    @ConfigurationProperties("spring.datasource.master")
//    fun masterDataSourceProperties(): DataSourceProperties {
//        return DataSourceProperties()
//    }
//
//    @Bean
//    fun masterDataSource(): DataSource {
//        return masterDataSourceProperties()
//            .initializeDataSourceBuilder()
//            .type(HikariDataSource::class.java)
//            .build()
//    }
//
//    // -----------------------------
//    // SLAVE
//    // -----------------------------
//
//    @Bean
//    @ConfigurationProperties("spring.datasource.slave")
//    fun slaveDataSourceProperties(): DataSourceProperties {
//        return DataSourceProperties()
//    }
//
//    @Bean
//    fun slaveDataSource(): DataSource {
//        return slaveDataSourceProperties()
//            .initializeDataSourceBuilder()
//            .type(HikariDataSource::class.java)
//            .build()
//    }
//
//    // -----------------------------
//    // ROUTING
//    // -----------------------------
//
//    @Primary
//    @Bean
//    fun routingDataSource(): DataSource {
//
//        val routingDataSource = ReplicationRoutingDataSource()
//
//        routingDataSource.setTargetDataSources(
//            mapOf(
//                DataSourceType.MASTER to masterDataSource(),
//                DataSourceType.SLAVE to slaveDataSource()
//            )
//        )
//
//        routingDataSource.setDefaultTargetDataSource(masterDataSource())
//
//        routingDataSource.afterPropertiesSet()
//
//        return routingDataSource
//    }
//
//    // -----------------------------
//    // TRANSACTION MANAGER
//    // -----------------------------
//
//    @Bean
//    fun transactionManager(
//        entityManagerFactory: EntityManagerFactory
//    ): PlatformTransactionManager {
//
//        return JpaTransactionManager(entityManagerFactory)
//    }
//}