package Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertFood(foodEntity: FoodEntity)

    @Update
    suspend fun UpdateFood(foodEntity: FoodEntity)

    @Delete
    suspend fun DeleteFood(foodEntity: FoodEntity)

    @Query("SELECT*FROM foodentity")
    fun getFood(): Flow<List<FoodEntity>>
}