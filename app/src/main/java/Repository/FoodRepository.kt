package Repository

import Database.FoodDao
import Database.FoodDatabase
import Database.FoodEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FoodRepository @Inject constructor(private val foodDatabase: FoodDatabase): FoodDao {
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