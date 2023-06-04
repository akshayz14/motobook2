package com.akshayz.motobook.utils

interface ActionPerformer<ACTION> {
    fun performAction(action: ACTION)
}