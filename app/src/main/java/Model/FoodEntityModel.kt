package Model

import Database.FoodEntity
import Repository.FoodRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodEntityModel @Inject constructor(private var foodRepository: FoodRepository) : ViewModel() {


    val foodData = MutableLiveData<List<FoodEntity>>()

    fun addfood (foodEntity: FoodEntity) = viewModelScope.launch {
        foodRepository.InsertFood(foodEntity)
    }

    private fun updateFoood(foodEntity: FoodEntity) = viewModelScope.launch {
        foodRepository.UpdateFood(foodEntity)
    }

    private fun deleteFood(foodEntity: FoodEntity) = viewModelScope.launch {
        foodRepository.DeleteFood(foodEntity)

    }

    fun getFood(): Flow<List<FoodEntity>> = foodRepository.getFood()




}