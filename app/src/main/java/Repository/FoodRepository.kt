package Repository

import Database.FoodDao
import Database.FoodEntity
import kotlinx.coroutines.flow.Flow

class FoodRepository: FoodDao {
    override suspend fun InsertFood(foodEntity: FoodEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun UpdateFood(foodEntity: FoodEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun DeleteFood(foodEntity: FoodEntity) {
        TODO("Not yet implemented")
    }

    override fun getFood(): Flow<List<FoodEntity>> {
        TODO("Not yet implemented")
    }
}