package Adapter

import Database.FoodEntity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dtrackerapp.databinding.CountriesBinding
import com.example.dtrackerapp.databinding.FragmentDietScheduleBinding

class DiaryScheduleAdapter: RecyclerView.Adapter<DiaryScheduleAdapter.Schedule>() {


    class Schedule (val binding: CountriesBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(foodEntity: FoodEntity){

            binding.apply {
                country.text = foodEntity.text

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Schedule {
        val binding = CountriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Schedule(binding)
    }

    override fun onBindViewHolder(holder: Schedule, position: Int) {

        holder.bind(differ.currentList[position])

    }

    override fun getItemCount(): Int = differ.currentList.size




    val diffUtil = object : DiffUtil.ItemCallback<FoodEntity>(){
        override fun areItemsTheSame(oldItem: FoodEntity, newItem: FoodEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FoodEntity, newItem: FoodEntity): Boolean {
            TODO("Not yet implemented")
        }


    }


    val differ = AsyncListDiffer (this, diffUtil)
}