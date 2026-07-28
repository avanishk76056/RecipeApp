package com.example.myrecipeapp.data.remote.repository

import com.example.myrecipeapp.data.remote.RecipeAPIService
import com.example.myrecipeapp.data.remote.dto.RecipeDTO
import com.example.myrecipeapp.domain.repository.RecipeRepository

class RecipeRepositoryImpl(private val apiService: RecipeAPIService): RecipeRepository {

    override suspend fun getAllRecipe(): List<RecipeDTO> {
        return apiService.getAllRecipes()
    }

    override suspend fun getRecipeById(id: Int): RecipeDTO {
        return apiService.getRecipeById(id)
    }
}