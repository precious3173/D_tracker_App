package Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FoodEntity")
data class FoodEntity(
    @ColumnInfo val text: String? = null,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
