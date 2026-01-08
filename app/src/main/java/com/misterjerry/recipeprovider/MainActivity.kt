package com.misterjerry.recipeprovider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.misterjerry.recipeprovider.ui.theme.RecipeProviderTheme
import com.misterjerry.recipeprovider.util.routing.NavigationRoot

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeProviderTheme {
                NavigationRoot()
            }
        }
    }
}

