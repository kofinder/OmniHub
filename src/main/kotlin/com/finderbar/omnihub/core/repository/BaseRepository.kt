package com.finderbar.omnihub.core.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface BaseRepository<T : Any, ID : Any> :
    JpaRepository<T, ID>,
    JpaSpecificationExecutor<T>