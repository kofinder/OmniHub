package com.finderbar.omnihub.config.api
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.servers.Server
import io.swagger.v3.oas.models.security.SecurityScheme
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.Components
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun openApi(): OpenAPI {
        val securitySchemeName = "bearerAuth"

        return OpenAPI()
            .info(
                Info()
                    .title("OmniHub API")
                    .version("v1")
                    .description("Enterprise Backend API Documentation")
                    .contact(
                        Contact()
                            .name("Backend Team")
                            .email("backend@omnihub.com")
                    )
            )
            .servers(
                listOf(
                    Server().url("http://localhost:8080").description("Local server"),
                    Server().url("https://api.omnihub.com").description("Production server")
                )
            )
            .components(
                Components().addSecuritySchemes(
                    securitySchemeName,
                    SecurityScheme()
                        .name(securitySchemeName)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                )
            )
            .addSecurityItem(
                SecurityRequirement().addList(securitySchemeName)
            )
    }
}