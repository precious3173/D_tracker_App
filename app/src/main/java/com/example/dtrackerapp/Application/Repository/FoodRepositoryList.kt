package com.example.dtrackerapp.Application.Repository

import com.example.dtrackerapp.Application.Database.FoodDatabase
import com.example.dtrackerapp.Application.Database.FoodEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FoodRepositoryList @Inject constructor(private val foodDatabase: FoodDatabase):
    FoodRepository {
    override suspend fun InsertFood(foodEntity: FoodEntity) {

        foodDatabase.foodDao().InsertFood(foodEntity)
    }

    override suspend fun UpdateFood(foodEntity: FoodEntity) {
        foodDatabase.foodDao().UpdateFood(foodEntity)
    }

    override suspend fun DeleteFood(foodEntity: FoodEntity) {
        foodDatabase.foodDao().DeleteFood(foodEntity)
    }

    override fun getFood(): Flow<List<FoodEntity>> {
        return foodDatabase.foodDao().getFood()
    }
}