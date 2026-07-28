package com.example.myrecipeapp.presentation.screens.recipe_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myrecipeapp.presentation.components.ErrorMessage
import com.example.myrecipeapp.presentation.components.LoadingIndicater
import com.example.myrecipeapp.presentation.components.MyTopBar
import com.example.myrecipeapp.presentation.screens.viewmodels.RecipedetailViewModel
import com.example.myrecipeapp.ui.theme.MyOrange

@Composable
fun RecipeDetailScreen(
    recipeId: Int,
    onBack: () -> Unit,
    viewModel: RecipedetailViewModel = viewModel()
){

    LaunchedEffect(recipeId) {
        viewModel.fetchRecipe(recipeId)
    }

    Scaffold(
        topBar = { MyTopBar(
            title = "Recipe Details",
            onBckCLick = onBack,
            icon = Icons.AutoMirrored.Filled.ArrowBack
        ) }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = MyOrange.copy(alpha = 0.02f))
        ) {

            when {

                viewModel.isLoading -> LoadingIndicater(strokeWidth = 1.dp)
            
            viewModel.errorMessage != null -> {
                ErrorMessage(
                    errorMessage = viewModel.errorMessage!!,
                    onRetry = {viewModel.fetchRecipe(recipeId)}
                )
            }

                viewModel.recipe != null -> {
                RecipeDetailContent(
                    details = viewModel.recipe!!
                )
                }
            }
        }

    }
}