package com.misterjerry.recipeprovider.presentation.result

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ResultViewModel(application: Application) : AndroidViewModel(application) {

    private val _state = MutableStateFlow(ResultState())
    val state: StateFlow<ResultState> = _state.asStateFlow()

    init {
        fetchSavedRecipes()
    }

    private fun fetchSavedRecipes() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            try {
                val ids = mutableListOf<String>()
                val uri = Uri.parse("content://com.misterjerry.gangnam2kiandroidstudy.provider/saved_recipes")
                
                val cursor = getApplication<Application>().contentResolver.query(
                    uri,
                    null,
                    null,
                    null,
                    null
                )

                cursor?.use {
                    val idIndex = it.getColumnIndex("id")
                    while (it.moveToNext()) {
                        if (idIndex != -1) {
                            ids.add(it.getString(idIndex))
                        }
                    }
                }
                
                _state.update { it.copy(recipeIds = ids, isLoading = false) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}
