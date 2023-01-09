package UserInterface

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.dtrackerapp.Application.Database.FoodEntity
import com.example.dtrackerapp.Application.Model.FoodEntityModel
import com.example.dtrackerapp.R
import com.example.dtrackerapp.databinding.FragmentDietScheduleBinding
import com.example.dtrackerapp.databinding.FragmentUpdateDietScheduleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateDietSchedule : Fragment() {

    private val foodEntityModel: FoodEntityModel by viewModels()
    val args: UpdateDietScheduleArgs by navArgs()
    private var binding: FragmentUpdateDietScheduleBinding?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateDietScheduleBinding.inflate(layoutInflater)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scheduletext: String = args.schedule.text
        val  foodEntity: FoodEntity = args.schedule


               val mealtext = binding!!.Umealtext
               val  add = binding!!.Uadd


        add.setOnClickListener {

            foodEntityModel.updateFoood(foodEntity)
            findNavController().navigate(R.id.action_updateDietSchedule_to_mealsTracker)
        }
                mealtext.setText(scheduletext)



                    mealtext.addTextChangedListener(object : TextWatcher {
                        override fun beforeTextChanged(
                            p0: CharSequence?,
                            p1: Int,
                            p2: Int,
                            p3: Int
                        ) {

                        }

                        override fun onTextChanged(
                            p0: CharSequence?,
                            p1: Int,
                            p2: Int,
                            p3: Int
                        ) {

                            mealtext.isEnabled = true

                        }

                        override fun afterTextChanged(p0: Editable?) {
                            mealtext.isEnabled = true
                        }

                    })





            }





}
