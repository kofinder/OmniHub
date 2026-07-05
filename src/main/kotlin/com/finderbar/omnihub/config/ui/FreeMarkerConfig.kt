package com.finderbar.omnihub.config.ui

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver

@Configuration
class FreeMarkerConfig {

    @Bean
    fun freeMarkerConfigurer(): FreeMarkerConfigurer {
        val configurer = FreeMarkerConfigurer()
        configurer.setTemplateLoaderPath("classpath:/templates/")
        configurer.setDefaultEncoding( "UTF-8")
        return configurer
    }

    @Bean
    fun freeMarkerViewResolver(): FreeMarkerViewResolver {
        val resolver = FreeMarkerViewResolver()
        resolver.setPrefix("")
        resolver.setSuffix(".ftl")
        resolver.setContentType("text/html; charset=UTF-8")
        resolver.isCache = false
        return resolver
    }
}