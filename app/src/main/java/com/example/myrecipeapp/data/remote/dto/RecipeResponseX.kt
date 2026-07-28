package com.example.myrecipeapp.data.remote.dto

data class RecipeResponseX(
    val limit: Int,
    val recipes: List<Recipe>,
    val skip: Int,
    val total: Int
)