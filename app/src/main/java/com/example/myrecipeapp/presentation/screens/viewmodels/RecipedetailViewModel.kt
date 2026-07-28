package com.example.myrecipeapp.presentation.screens.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrecipeapp.data.remote.KtorClient
import com.example.myrecipeapp.data.remote.RecipeAPIService
import com.example.myrecipeapp.data.remote.dto.RecipeDTO
import com.example.myrecipeapp.data.remote.repository.RecipeRepositoryImpl
import kotlinx.coroutines.launch

class RecipedetailViewModel: ViewModel() {

    private val repository: com.example.myrecipeapp.domain.repository.RecipeRepository =
        RecipeRepositoryImpl(apiService = RecipeAPIService(KtorClient.client))

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    var recipe by mutableStateOf<RecipeDTO?>(null)
        private set

    fun fetchRecipe(id: Int){

        isLoading = true
        errorMessage = null

        try {
            viewModelScope.launch {
                recipe = repository.getRecipeById(id)
            }
        } catch (e: Exception){
            errorMessage = e.message ?: "An unknown error occurred"
        }finally {
            isLoading = false
        }
    }
}