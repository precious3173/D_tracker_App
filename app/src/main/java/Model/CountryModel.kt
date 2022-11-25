package Model



data class CountryModel (var country: String)

//     object Country {
//
//
//         val country = arrayListOf(
//             "Nigeria", "", "", "",
//             "", "", "", ""
//         )
//
//         var countryList: ArrayList<CountryModel>? = null
//             get() {
//                 if (field != null)
//                     return field
//                 field = ArrayList()
//
//
//                 for (i in country.indices) {
//
//                 val country = country[i]
//
//                     val countrylists = CountryModel(country)
//
//                     field!!.add(countrylists)
//                 }
//
//                 return field
//             }
//
//
//         val countryModel: MutableList<CountryModel> = mutableListOf()
