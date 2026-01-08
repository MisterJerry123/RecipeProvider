package com.misterjerry.recipeprovider.util.routing

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface Route: NavKey {
    @Serializable
    data object Home : Route

    @Serializable
    data object Result : Route
}