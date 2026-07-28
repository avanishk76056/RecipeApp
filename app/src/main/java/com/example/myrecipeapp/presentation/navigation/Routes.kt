package com.example.myrecipeapp.presentation.navigation

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

@Serializable
object HomeRoutes {

}
@Serializable
data class RecipeDetailRoute(val  recipeId: Int)