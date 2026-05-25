package com.finderbar.omnihub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer


@SpringBootApplication
class OmniHubApplication : SpringBootServletInitializer() {
    override fun configure(builder: SpringApplicationBuilder): SpringApplicationBuilder {
        return builder.sources(OmniHubApplication::class.java)
    }
}

fun main(args: Array<String>) {
    runApplication<OmniHubApplication>(*args)
}
