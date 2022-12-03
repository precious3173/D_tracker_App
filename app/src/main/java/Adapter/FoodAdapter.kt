package Adapter

import Model.FoodModel
import UserInterface.CountryFoodDirections
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dtrackerapp.databinding.FoodLayoutBinding
import com.example.dtrackerapp.databinding.FragmentFoodDetailsBinding
import java.util.Objects

class FoodAdapter: RecyclerView.Adapter<FoodAdapter.FoodHolder>() {

    class FoodHolder(private val binding: FoodLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind (foodModel: FoodModel) {

            binding.apply {

               foodImage.setImageResource(foodModel.foodImage)
                 food.text = foodModel.food

                binding.foodImage.setOnClickListener {

                 val action = CountryFoodDirections.actionCountryFoodToFoodDetails(foodModel)

                    Navigation.findNavController(it).navigate(action)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        val binding = FoodLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return FoodHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {

        holder.bind(diffUtil.currentList.get(position))
    }

    override fun getItemCount(): Int = diffUtil.currentList.size


    private val differCall = object: DiffUtil.ItemCallback<FoodModel>(){
        override fun areItemsTheSame(oldItem: FoodModel, newItem: FoodModel): Boolean {

            return oldItem.food == newItem.food
        }

        override fun areContentsTheSame(oldItem: FoodModel, newItem: FoodModel): Boolean {

            return oldItem == newItem
        }

    }

    val diffUtil = AsyncListDiffer(this, differCall)
}


