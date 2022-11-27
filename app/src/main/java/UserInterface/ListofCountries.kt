package UserInterface

import Adapter.CountryListAdapter
import ArrayListofItems.MutableListOfCountries
import Model.CountryModel
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import com.example.dtrackerapp.databinding.FragmentListofCountriesBinding


class ListofCountries : Fragment() {

   lateinit var binding: FragmentListofCountriesBinding
   val mutableListOfCountries: MutableListOfCountries = MutableListOfCountries()
   val countryModels: CountryModel? = null
    val countryListAdapter = CountryListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // to get details from layout
        binding = FragmentListofCountriesBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



         //to add list of countries
        countryListAdapter.differ.submitList(mutableListOfCountries.mute())

                 binding.recyclerview.apply {

                     adapter = countryListAdapter
                     setHasFixedSize(true)
                 }


        binding.searchview.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(searchItems: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(searchItems: String?): Boolean {

                filter(searchItems!!)

                return false
            }

        })

        }


     fun filter(searchItems: String){

        val filterCountry = mutableListOf<CountryModel>()

         for (countrys in mutableListOfCountries.mute()) {


             if (countrys.country.toLowerCase()
                     .contains(searchItems.lowercase(java.util.Locale.getDefault()))
             ) {

                 filterCountry.add(countrys)
             }
             if(filterCountry.isNotEmpty()){

                 mutableListOfCountries.mute()
                 countryListAdapter.differ.submitList(filterCountry)
             }

             else {

                 mutableListOfCountries.mute().clear()

             }
         }


             }

         }



