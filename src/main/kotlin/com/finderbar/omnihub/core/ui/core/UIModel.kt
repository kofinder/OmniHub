package com.finderbar.omnihub.core.ui.core

/**
 * Base UI model container for model data, configuration, and runtime context.
 *
 * Author: Ko Thein
 * Created: 2026-05-01
 */

abstract class UIModel<M, C, CX>(
    open val model: M,
    open val config: C,
    open val context: CX
) {
    abstract val templatePath: String
}