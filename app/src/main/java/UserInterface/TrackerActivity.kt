package UserInterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dtrackerapp.R

class TrackerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracker)
    }
}