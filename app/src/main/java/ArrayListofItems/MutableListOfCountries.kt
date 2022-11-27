package ArrayListofItems

import Model.CountryModel

class MutableListOfCountries {
    fun mute(): MutableList<CountryModel>{
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

        return countryModel
    }
}