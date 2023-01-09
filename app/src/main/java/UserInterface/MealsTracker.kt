package UserInterface

import Adapter.DiaryScheduleAdapter
import com.example.dtrackerapp.Application.Database.FoodEntity
import com.example.dtrackerapp.Application.Model.FoodEntityModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import com.example.dtrackerapp.R
import com.example.dtrackerapp.databinding.FragmentMealsTrackerBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MealsTracker : Fragment(), DiaryScheduleAdapter.deleteSchedule {

    val diaryScheduleAdapter = DiaryScheduleAdapter(this)
    lateinit var binding: FragmentMealsTrackerBinding
   private val foodModel: FoodEntityModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMealsTrackerBinding.inflate(layoutInflater)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



       binding.edit.setOnClickListener {

        findNavController().navigate(R.id.action_mealsTracker_to_dietSchedule)
       }


        lifecycle.coroutineScope.launch(){

            foodModel.getFood().collect{


                diaryScheduleAdapter.differ.submitList(it)

                binding.recyclerview.apply {

                    adapter = diaryScheduleAdapter
                    setHasFixedSize(true)
                }
            }

        }



    }

    override fun deleteSchedules(foodEntity: FoodEntity) {
        foodModel.deleteFood(foodEntity)
    }
}