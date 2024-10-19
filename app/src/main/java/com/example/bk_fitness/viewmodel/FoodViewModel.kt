package com.example.bk_fitness.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bk_fitness.model.Food
import com.example.bk_fitness.model.repository.ApiRepository
import kotlinx.coroutines.launch

class FoodViewModel : ViewModel() {
    private val repository = ApiRepository()

    private val _foods = MutableLiveData<Food>()
    val foods: LiveData<Food> = _foods

    fun fetchFoods() {
        viewModelScope.launch() {
            try {
                val food = repository.getFood()
                _foods.value = food
                Log.d("cuu", "CUU")
            } catch (e : Exception) {
                Log.e("Repo", "Fetch employee exception ${e.message}")
            }
        }
    }
}