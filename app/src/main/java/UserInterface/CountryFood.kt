package UserInterface

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.graphics.Color
import androidx.navigation.fragment.navArgs
import com.example.dtrackerapp.R
import com.example.dtrackerapp.databinding.FragmentCountryFoodBinding


class CountryFood : Fragment() {

    var binding:FragmentCountryFoodBinding? = null
    val args: CountryFoodArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCountryFoodBinding.inflate(layoutInflater)

        return binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val country: String = args.country.country

        when (country){

            "Nigeria" -> Toast.makeText(context, "Nigeria Meals", Toast.LENGTH_SHORT).show()

            "Ghana" -> Toast.makeText(context, "Ghana Meals", Toast.LENGTH_SHORT).show()

            "Ethiopia" -> Toast.makeText(context, "Ethiopia Meals", Toast.LENGTH_SHORT).show()
        }
    }
}