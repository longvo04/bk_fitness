package com.example.bk_fitness.model.api
import com.example.bk_fitness.model.Food
import retrofit2.http.GET

interface GetFoodService {
    @GET("food")
    suspend fun getFoods(): Food
}