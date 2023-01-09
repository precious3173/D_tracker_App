package com.example.dtrackerapp.Application.Database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity (tableName = "Foodentity")
@Parcelize
data class FoodEntity(
    @ColumnInfo var text: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
): Parcelable
