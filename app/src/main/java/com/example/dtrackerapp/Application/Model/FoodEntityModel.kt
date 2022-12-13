package com.example.dtrackerapp.Application.Model

import com.example.dtrackerapp.Application.Database.FoodEntity
import com.example.dtrackerapp.Application.Repository.FoodRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodEntityModel @Inject constructor(
    private val foodRepositoryList: FoodRepository
) : ViewModel() {


    val foodData = MutableLiveData<List<FoodEntity>>()

    fun addfood (foodEntity: FoodEntity) = viewModelScope.launch {
        foodRepositoryList.InsertFood(foodEntity)
    }

    fun updateFoood(foodEntity: FoodEntity) = viewModelScope.launch {
        foodRepositoryList.UpdateFood(foodEntity)
    }

    fun deleteFood(foodEntity: FoodEntity) = viewModelScope.launch {
        foodRepositoryList.DeleteFood(foodEntity)

    }

    fun getFood(): Flow<List<FoodEntity>> = foodRepositoryList.getFood()




}