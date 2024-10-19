package com.example.bk_fitness.model.api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://6713d5ef690bf212c75feda7.mockapi.io/"
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getFoodService: GetFoodService by lazy {
        retrofit.create(GetFoodService::class.java)
    }
}