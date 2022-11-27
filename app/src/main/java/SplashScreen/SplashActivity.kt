package SplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dtrackerapp.R
import UserInterface.TrackerActivity
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        // Using Coroutine to move to the next activity after 9 seconds
            CoroutineScope(Dispatchers.Main).launch{
           delay(1000L)

           startActivity(Intent(this@SplashActivity, TrackerActivity::class.java))
                finish()

       }
    }
}