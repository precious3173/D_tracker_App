package UserInterface

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dtrackerapp.R
import com.example.dtrackerapp.databinding.FragmentMealsTrackerBinding


class MealsTracker : Fragment() {
       lateinit var binding: FragmentMealsTrackerBinding
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
    }
}