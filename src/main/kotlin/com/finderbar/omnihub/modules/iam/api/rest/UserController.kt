package com.finderbar.omnihub.modules.iam.api.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class UserController {

    @GetMapping("/test")
    fun test(): Map<String, String> {
        return mapOf(
            "message" to "OAuth2 secured API works"
        )
    }

}