package com.example.bk_fitness.model.repository

import com.example.bk_fitness.model.Food
import com.example.bk_fitness.model.api.RetrofitInstance

class ApiRepository {
    private val foodService = RetrofitInstance.getFoodService

    suspend fun getFood() : Food {
        return foodService.getFoods()
    }
}