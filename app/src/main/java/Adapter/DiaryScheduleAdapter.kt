package Adapter

import UserInterface.DeleteDialog
import android.app.AlertDialog
import android.content.Context
import com.example.dtrackerapp.Application.Database.FoodEntity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dtrackerapp.databinding.SchedulesBinding

class DiaryScheduleAdapter(delete: deleteSchedule): RecyclerView.Adapter<DiaryScheduleAdapter.Schedule>() {


   // private var deleteSchedules: deleteSchedule = deleteSchedules
   interface deleteSchedule{

        fun deleteSchedules(foodEntity: FoodEntity)
    }
        var delete: deleteSchedule? = null
        init {

            this.delete = delete
        }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Schedule {
        val binding = SchedulesBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Schedule(binding)
    }

    override fun onBindViewHolder(holder: Schedule, position: Int) {

        delete?.let { holder.bind(differ.currentList[position], it) }

    }

    override fun getItemCount(): Int = differ.currentList.size


    class Schedule (val binding: SchedulesBinding): RecyclerView.ViewHolder(binding.root) {


        fun bind(foodEntity: FoodEntity, deleteSchedules: deleteSchedule){

            binding.apply {
                country.text = foodEntity.text
                var context: Context = binding.root.context

                binding.root.setOnClickListener {

                    val builder = AlertDialog.Builder(context)
                    builder.setTitle("Delete Schedule")
                    builder.setMessage("Do you want to delete?")

                    builder.setPositiveButton("Delete") { dialog, which ->

                        if (deleteSchedules!= null) {
                            deleteSchedules!!.deleteSchedules(foodEntity)

                            Toast.makeText(
                                context,
                                "Schedule deleted", Toast.LENGTH_SHORT
                            ).show()
                        }
                    }


                    builder.setNegativeButton("Cancel") { dialog, which ->
                    }


                    builder.show()




                }

            }




        }
    }


    val diffUtil = object : DiffUtil.ItemCallback<FoodEntity>(){
        override fun areItemsTheSame(oldItem: FoodEntity, newItem: FoodEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FoodEntity, newItem: FoodEntity): Boolean {
            return  oldItem == newItem
        }


    }


    val differ = AsyncListDiffer (this, diffUtil)




}


