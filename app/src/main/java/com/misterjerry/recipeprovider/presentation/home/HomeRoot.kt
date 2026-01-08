package com.misterjerry.recipeprovider.presentation.home

import androidx.compose.runtime.Composable

@Composable
fun HomeRoot(
    onNavigateToResult: () -> Unit,
) {
    HomeScreen(
        onNavigateToResult = onNavigateToResult
    )
}