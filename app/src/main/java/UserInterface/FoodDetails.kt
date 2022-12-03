package UserInterface

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.dtrackerapp.R
import com.example.dtrackerapp.databinding.FragmentFoodDetailsBinding


class FoodDetails : Fragment() {
    val args: FoodDetailsArgs by navArgs()
    lateinit var  binding: FragmentFoodDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFoodDetailsBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val foodCalorie: String = args.food.food

        val foodImage: Int = args.food.foodImage

        binding.foodImage.setImageResource(foodImage)
        binding.foodName.text = foodCalorie

        when(foodCalorie){

            "Rice" -> binding.foodDetail.text = getString(R.string.Rice)
            "Beans" -> binding.foodDetail.text = getString(R.string.Beans)
            "Fried Plantain" -> binding.foodDetail.text = getString(R.string.Plantain)
        }
    }

}