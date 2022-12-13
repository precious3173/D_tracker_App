package com.example.dtrackerapp.Application.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Foodentity")
data class FoodEntity(
    @ColumnInfo val text: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
