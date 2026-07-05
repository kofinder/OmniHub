package com.finderbar.omnihub.core.ui.usecase

abstract class UseCase<M, C, CX>(
    protected val model: M,
    protected val config: C,
    protected val context: CX
)