package ArrayListofItems

import Model.CountryModel
import Model.FoodModel
import com.example.dtrackerapp.R

class ListofItems {
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

    fun Nigeria (): MutableList<FoodModel>{
        val NigeriaMeals: MutableList<FoodModel> = mutableListOf()

        NigeriaMeals.add(FoodModel("Rice", R.drawable.rice))
        NigeriaMeals.add(FoodModel("Beans", R.drawable.beans))
        NigeriaMeals.add(FoodModel("Egusi", R.drawable.egusi))
        NigeriaMeals.add(FoodModel("Fried Plantain", R.drawable.fried_plantain))
        NigeriaMeals.add(FoodModel("Toasted Bread", R.drawable.toasted_bread))
        NigeriaMeals.add(FoodModel("Rice", R.drawable.rice))
        NigeriaMeals.add(FoodModel("Beans", R.drawable.beans))
        NigeriaMeals.add(FoodModel("Egusi", R.drawable.egusi))
        NigeriaMeals.add(FoodModel("Fried Plantain", R.drawable.fried_plantain))
        NigeriaMeals.add(FoodModel("Toasted Bread", R.drawable.toasted_bread))
        NigeriaMeals.add(FoodModel("Rice", R.drawable.rice))

        return NigeriaMeals
    }

    fun Kenya (): MutableList<FoodModel>{
        val KenyaMeals: MutableList<FoodModel> = mutableListOf()

        KenyaMeals.add(FoodModel("Ugali", R.drawable.ugali))
        KenyaMeals.add(FoodModel("Sukuma Wiki", R.drawable.sukuma_wiki))
        KenyaMeals.add(FoodModel("Nyama Choma", R.drawable.nyama_choma))
        KenyaMeals.add(FoodModel("Chips Mayai", R.drawable.chips_mayai))
        KenyaMeals.add(FoodModel("Ugali", R.drawable.ugali))
        KenyaMeals.add(FoodModel("Sukuma Wiki", R.drawable.sukuma_wiki))
        KenyaMeals.add(FoodModel("Nyama Choma", R.drawable.nyama_choma))
        KenyaMeals.add(FoodModel("Chips Mayai", R.drawable.chips_mayai))
        KenyaMeals.add(FoodModel("Ugali", R.drawable.ugali))
        KenyaMeals.add(FoodModel("Sukuma Wiki", R.drawable.sukuma_wiki))
        KenyaMeals.add(FoodModel("Nyama Choma", R.drawable.nyama_choma))
        KenyaMeals.add(FoodModel("Chips Mayai", R.drawable.chips_mayai))
        return KenyaMeals
    }
}