package com.example.dtrackerapp.Application.Repository

import com.example.dtrackerapp.Application.Database.FoodEntity
import kotlinx.coroutines.flow.Flow

interface FoodRepository {

   suspend fun InsertFood(foodEntity: FoodEntity)

    suspend fun UpdateFood(foodEntity: FoodEntity)
     suspend fun DeleteFood(foodEntity: FoodEntity)

    fun getFood(): Flow<List<FoodEntity>>
}