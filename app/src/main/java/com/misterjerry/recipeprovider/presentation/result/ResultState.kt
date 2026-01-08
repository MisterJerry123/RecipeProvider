package com.misterjerry.recipeprovider.presentation.result

data class ResultState(
    val recipeIds: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
