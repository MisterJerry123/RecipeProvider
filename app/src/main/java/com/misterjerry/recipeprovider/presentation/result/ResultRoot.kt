package com.misterjerry.recipeprovider.presentation.result

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ResultRoot(
    viewModel: ResultViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()
    ResultScreen(state = state)
}
