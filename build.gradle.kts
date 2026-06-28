plugins {
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.spring") version "2.2.21"
    war
    id("org.springframework.boot") version "4.0.6"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("plugin.jpa") version "2.2.21"
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
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")

    // -----------------------------
    // Templates
    // -----------------------------
    implementation("org.springframework.boot:spring-boot-starter-freemarker")

    // -----------------------------
    // Security
    // -----------------------------
//    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-security")
//    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
//    implementation("org.springframework.boot:spring-boot-starter-oauth2-authorization-server")


    //-----------------------------
    // JWT
    //-----------------------------
    implementation("io.jsonwebtoken:jjwt-api:0.12.7")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.7")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.7")

    // -----------------------------
    // GraphQL
    // -----------------------------
    implementation("org.springframework.boot:spring-boot-starter-graphql")

    // -----------------------------
    // Database
    // -----------------------------
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-flyway")
    implementation("org.flywaydb:flyway-database-postgresql")
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
//    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    implementation("org.springframework.boot:spring-boot-starter-tomcat")

    // -----------------------------
    // Testing
    // -----------------------------
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
    }
}


allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

tasks.withType<War> {
    enabled = true
}

tasks.withType<Test> {
    useJUnitPlatform()
}