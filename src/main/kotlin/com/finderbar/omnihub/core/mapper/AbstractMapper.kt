package com.finderbar.omnihub.core.mapper

abstract class AbstractMapper<E, R, C, U> :
    ResponseMapper<E, R>,
    CreateMapper<C, E>,
    UpdateMapper<U, E>