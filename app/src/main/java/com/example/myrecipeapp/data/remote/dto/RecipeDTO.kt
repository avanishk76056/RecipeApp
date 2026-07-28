package com.example.myrecipeapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeDTO(
    val caloriesPerServing: Int,
    val cookTimeMinutes: Int,
    val cuisine: String,
    val difficulty: String,
    val id: Int,
    val image: String,
    val ingredients: List<String>,

    @SerialName("instructions")
    val instructions: List<String>,

    val mealType: List<String>,
    val name: String,

    @SerialName("prepTimeMinutes")
    val prepTimeMinutes: Int,

    val rating: Double,
    val reviewCount: Int,

    @SerialName("servings")
    val servings: Int,

    val tags: List<String>,
    val userId: Int
)