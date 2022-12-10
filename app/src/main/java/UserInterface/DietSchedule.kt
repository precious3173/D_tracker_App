package UserInterface

import Database.FoodEntity
import Model.CountryModel
import Model.FoodEntityModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.fragment.findNavController
import com.example.dtrackerapp.R
import com.example.dtrackerapp.databinding.FragmentDietScheduleBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DietSchedule : Fragment() {


    private val foodEntityModel: FoodEntityModel by viewModels()
    //private val foodEntity: FoodEntity? = null
    private var binding: FragmentDietScheduleBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDietScheduleBinding.inflate(layoutInflater)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding!!.apply {


            add.setOnClickListener {

                if (mealtext.text.isNotEmpty()){
              foodEntityModel.addfood(FoodEntity(
                  mealtext.text.toString()
              ))

                    findNavController().navigate(R.id.action_dietSchedule_to_mealsTracker)

                } else{

                    Toast.makeText(context, "Please enter text", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}