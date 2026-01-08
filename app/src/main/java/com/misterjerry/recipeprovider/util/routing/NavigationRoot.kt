package com.misterjerry.recipeprovider.util.routing

import androidx.compose.runtime.Composable

import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.misterjerry.recipeprovider.presentation.home.HomeRoot
import com.misterjerry.recipeprovider.presentation.result.ResultRoot

@Composable
fun NavigationRoot() {
    val backStack = rememberNavBackStack(Route.Home)

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<Route.Home> {
                HomeRoot(onNavigateToResult = {
                    backStack.add(Route.Result)
                })

            }
            entry<Route.Result> {
                ResultRoot()

            }
        }

    )
}