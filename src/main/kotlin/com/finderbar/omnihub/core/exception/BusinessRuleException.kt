package com.finderbar.omnihub.core.exception

import org.springframework.http.HttpStatus


class BusinessRuleException(
    rule: String,
    message: String
) : DomainException(
    code = "BUSINESS_RULE_VIOLATION",
    message = "Rule '$rule' violated: $message",
    httpStatus = HttpStatus.UNPROCESSABLE_ENTITY
)