plugins {
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.spring") version "2.2.21"
    kotlin("plugin.jpa") version "2.2.21"

    id("org.springframework.boot") version "4.0.6"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "org.kt"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {

    // REST API + MVC
    implementation("org.springframework.boot:spring-boot-starter-web")

    // FreeMarker Templates
    implementation("org.springframework.boot:spring-boot-starter-freemarker")

    // GraphQL
    implementation("org.springframework.boot:spring-boot-starter-graphql")

    // JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // Kotlin Jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // PostgreSQL
    runtimeOnly("org.postgresql:postgresql:42.7.3")

    // Devtools
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // Config processor
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    // Tests
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testImplementation("org.springframework.graphql:spring-graphql-test")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll(
            "-Xjsr305=strict",
            "-Xannotation-default-target=param-property"
        )
    }
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
    useJUnitPlatform()
}