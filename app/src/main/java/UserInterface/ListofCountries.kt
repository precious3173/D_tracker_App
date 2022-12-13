package UserInterface

import Adapter.CountryListAdapter
import ArrayListofItems.ListofItems
import com.example.dtrackerapp.Application.Model.CountryModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.navigation.fragment.findNavController
import com.example.dtrackerapp.R
import com.example.dtrackerapp.databinding.FragmentListofCountriesBinding


class ListofCountries : Fragment() {

   lateinit var binding: FragmentListofCountriesBinding
   val listofItems: ListofItems = ListofItems()
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


        binding.next.setOnClickListener {

            findNavController().navigate(R.id.action_listofCountries_to_mealsTracker)
        }


         //to add list of countries
        countryListAdapter.differ.submitList(listofItems.mute())

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

         for (countrys in listofItems.mute()) {


             if (countrys.country.toLowerCase()
                     .contains(searchItems.lowercase(java.util.Locale.getDefault()))
             ) {

                 filterCountry.add(countrys)
             }
             if(filterCountry.isNotEmpty()){

                 listofItems.mute()
                 countryListAdapter.differ.submitList(filterCountry)
             }

             else {

                 listofItems.mute().clear()

             }
         }


             }

         }



