package com.example.bk_fitness.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.bk_fitness.model.FoodItem
import com.example.bk_fitness.viewmodel.FoodViewModel

@Composable
fun FoodComposable(viewModel: FoodViewModel) {
    val foods by viewModel.foods.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchFoods()
    }

    Column(modifier = Modifier
        .wrapContentSize()
        .clip(RoundedCornerShape(4.dp))
        .padding(16.dp)
    ) {
        if (foods.isNullOrEmpty()) {
            println(foods)
            Text("Loading...")
        } else {
            val fetchedFoods = foods as List<FoodItem>
            fetchedFoods.let {
                LazyColumn {
                    items(it) {
                        Text("Food: ${it.food_name}")
                        Text("ID: ${it.id}")
                        Text("Serving Size: ${it.serving_qty}")
                        Text("Calories: ${it.calories}")
                        HorizontalDivider()
                    }
                }
            }
        }
    }

}
