package UserInterface

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dtrackerapp.Application.Database.FoodEntity
import com.example.dtrackerapp.Application.Model.FoodEntityModel
import dagger.hilt.android.AndroidEntryPoint

class DeleteDialog(): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

       val builder = AlertDialog.Builder(context)
            builder.setMessage("Delete Schedule")

        builder.setPositiveButton("Delete"){
             _,_ ->

            fun void (foodEntity: FoodEntity){

            }
        }

        builder.setNegativeButton("Cancel"){
                _,_ ->
        }

       return builder.create()
    }
}