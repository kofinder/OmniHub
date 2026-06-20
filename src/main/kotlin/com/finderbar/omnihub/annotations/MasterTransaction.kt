package com.finderbar.omnihub.annotations

import org.springframework.transaction.annotation.Transactional

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Transactional
annotation class MasterTransaction