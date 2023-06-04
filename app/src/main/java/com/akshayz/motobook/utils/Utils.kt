package com.akshayz.motobook.utils

import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavGraph



fun NavController.navigateSafe(@IdRes resId: Int, args: Bundle? = null) {
    val destinationId = currentDestination?.getAction(resId)?.destinationId
    try {
        if (currentDestination != null) {
            currentDestination?.let { node ->
                val currentNode = when (node) {
                    is NavGraph -> node
                    else -> node.parent
                }
                if (destinationId != null) {
                    currentNode?.findNode(destinationId)?.let { navigate(resId, args) }
                }
            }
        } else {
            Log.d("dukaanError::::", "destination is null")
        }
    } catch (e: Exception) {
        Log.d("dukaanError::::", e.printStackTrace().toString())
    }
}