package com.example.myrecipeapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RecipeResponse (
    val racipes: List<RecipeDTO>,
    val  total: Int,
    val skip: Int,
    val limit: Int
)

