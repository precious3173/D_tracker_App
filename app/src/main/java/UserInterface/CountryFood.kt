package UserInterface

import Adapter.FoodAdapter
import ArrayListofItems.ListofItems
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.dtrackerapp.R
import com.example.dtrackerapp.databinding.FragmentCountryFoodBinding


class CountryFood : Fragment() {

    var binding:FragmentCountryFoodBinding? = null
    val args: CountryFoodArgs by navArgs()
    val listofItems: ListofItems = ListofItems()
    val foodAdapter: FoodAdapter = FoodAdapter()


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


        binding!!.next.setOnClickListener {

            findNavController().navigate(R.id.action_countryFood_to_mealsTracker)
        }
        binding!!.recyclerview.apply {

            adapter = foodAdapter
            setHasFixedSize(true)
        }

        val country: String = args.country.country

        when (country){

            "Nigeria" -> { binding!!.countryName.setText("Nigerian Food")

              foodAdapter.diffUtil.submitList(listofItems.Nigeria())
            }

            "Ghana" -> {
            binding!!.countryName.setText("Ghana Food")
            }

            "Ethiopia" -> Toast.makeText(context, "Ethiopia Meals", Toast.LENGTH_SHORT).show()

            "Kenya" -> { binding!!.countryName.setText("Kenya Food")

                foodAdapter.diffUtil.submitList(listofItems.Kenya())
            }
        }
    }
}