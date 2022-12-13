package Adapter

import com.example.dtrackerapp.Application.Model.CountryModel
import com.example.dtrackerapp.Application.Model.FoodModel
import UserInterface.ListofCountries
import UserInterface.ListofCountriesDirections
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.navigation.Navigation
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dtrackerapp.R
import com.example.dtrackerapp.databinding.CountriesBinding
import com.example.dtrackerapp.databinding.FragmentListofCountriesBinding


class CountryListAdapter: RecyclerView.Adapter<CountryListAdapter.CountryHolder>() {

   class CountryHolder(private val binding: CountriesBinding) : RecyclerView.ViewHolder(binding.root){
        fun fixItems(countryModel: CountryModel){

            binding.apply {
                country.text = countryModel.country


                 country.setOnClickListener {

//                     val bundle: Bundle = Bundle()
//                     bundle.putString("country", country.toString())
                   val action = ListofCountriesDirections.actionListofCountriesToCountryFood(countryModel)

                     Navigation.findNavController(it).navigate(action)
                 }
            }


        }

   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val binding = CountriesBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return CountryHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        holder.fixItems(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size



   private val differCallbacks = object:
    DiffUtil.ItemCallback<CountryModel>(){
       override fun areItemsTheSame(oldItem: CountryModel, newItem: CountryModel): Boolean {
           return oldItem.country == newItem.country
       }

       override fun areContentsTheSame(oldItem: CountryModel, newItem: CountryModel): Boolean {
        return  oldItem == newItem
       }

   }

    val differ = AsyncListDiffer(this, differCallbacks)




}
