package com.example.dtrackerapp

import Adapter.CountryListAdapter
import Model.CountryModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dtrackerapp.databinding.CountriesBinding
import com.example.dtrackerapp.databinding.FragmentListofCountriesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Collections


class ListofCountries : Fragment() {

   lateinit var binding: FragmentListofCountriesBinding
   //lateinit var countryModels: CountryModel
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




        val countryListAdapter = CountryListAdapter()

        val countryModel: MutableList<CountryModel> = mutableListOf()
        countryModel.add(CountryModel("Nigeria"))
        countryModel.add(CountryModel("Ghana"))
        countryModel.add(CountryModel("Ethiopia"))
       countryModel.add(CountryModel("Egypt"))
        countryModel.add(CountryModel("Kenya"))
        countryModel.add(CountryModel("Tanzania"))
        countryModel.add(CountryModel("South Africa"))
        countryModel.add(CountryModel("Uganda"))
        countryModel.add(CountryModel("Botswana"))
        countryModel.add(CountryModel("Lesotho"))
        countryModel.add(CountryModel("Nambibia"))
        countryModel.add(CountryModel("Swaziland"))
        countryModel.add(CountryModel("Somalia"))
        countryModel.add(CountryModel("Seychelles"))
        countryModel.add(CountryModel("Rwanda"))
        countryModel.add(CountryModel("Mozambique"))
        countryModel.add(CountryModel("Mauritius"))
        countryModel.add(CountryModel("Malawi"))



        countryListAdapter.differ.submitList(countryModel)

                 binding.recyclerview.apply {

                     adapter = countryListAdapter
                     setHasFixedSize(true)
                 }




        }



    }
