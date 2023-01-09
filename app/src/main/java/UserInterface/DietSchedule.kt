package UserInterface


import com.example.dtrackerapp.Application.Database.FoodEntity
import com.example.dtrackerapp.Application.Model.FoodEntityModel
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.dtrackerapp.R
import com.example.dtrackerapp.databinding.FragmentDietScheduleBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DietSchedule : Fragment(){

    private val foodEntityModel: FoodEntityModel by viewModels()
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

                    if (!mealtext.text.equals("")) {
                        foodEntityModel.addfood(
                            FoodEntity(
                                mealtext.text.toString()
                            )
                        )

                        findNavController().navigate(R.id.action_dietSchedule_to_mealsTracker)

                    } else {

                        Toast.makeText(context, "Please enter text", Toast.LENGTH_SHORT).show()
                    }
                }
            }




    }

}