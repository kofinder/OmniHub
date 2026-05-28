plugins {
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.spring") version "2.2.21"
    kotlin("plugin.jpa") version "2.2.21"

    id("org.springframework.boot") version "4.0.0"
    id("io.spring.dependency-management") version "1.1.7"

    war
}

group = "com.omnihub"
version = "0.0.1-SNAPSHOT"
description = "OmniHub"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {

    // -----------------------------
    // Spring Boot
    // -----------------------------
    implementation("org.springframework.boot:spring-boot-starter-web")

    // -----------------------------
    // Templates
    // -----------------------------
    implementation("org.springframework.boot:spring-boot-starter-freemarker")

    // -----------------------------
    // Security
    // -----------------------------
//    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-authorization-server")

    // -----------------------------
    // GraphQL
    // -----------------------------
    implementation("org.springframework.boot:spring-boot-starter-graphql")

    // -----------------------------
    // Database
    // -----------------------------
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("org.flywaydb:flyway-core")

    runtimeOnly("org.postgresql:postgresql")

    // -----------------------------
    // Kotlin
    // -----------------------------
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

    // -----------------------------
    // Development
    // -----------------------------
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // -----------------------------
    // Tomcat WAR
    // -----------------------------
    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")

    // -----------------------------
    // Testing
    // -----------------------------
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testImplementation("org.springframework.security:spring-security-test")

    testImplementation("org.springframework.graphql:spring-graphql-test")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll(
            "-Xjsr305=strict"
        )
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}