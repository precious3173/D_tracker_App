package com.example.dtrackerapp.Application.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class FoodModel(val food: String, val foodImage: Int): Parcelable
