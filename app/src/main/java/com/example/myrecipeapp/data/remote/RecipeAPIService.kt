package com.example.myrecipeapp.data.remote

import com.example.myrecipeapp.data.remote.dto.AddRecipeRequest
import com.example.myrecipeapp.data.remote.dto.RecipeDTO
import com.example.myrecipeapp.data.remote.dto.RecipesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class RecipeAPIService(
    private val client: HttpClient
) {

    // Get all recipes
    suspend fun getAllRecipes(): List<RecipeDTO> {
        val response: RecipesResponse =
            client.get("${KtorClient.BASE_URL}recipes").body()

        return response.recipes
    }

    // Get recipe by id
    suspend fun getRecipeById(id: Int): RecipeDTO {
        return client.get("${KtorClient.BASE_URL}recipes/$id").body()
    }

    // Add recipe
    suspend fun addRecipe(request: AddRecipeRequest): RecipeDTO {
        return client.post("${KtorClient.BASE_URL}recipes/add") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }
}