package com.example.caddiefynacho

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.caddiefynacho.ui.theme.CaddiefyNachoTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaddiefyNachoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val poppinsFamily = FontFamily(
                        Font(R.font.poppins_light, FontWeight.Light),
                        Font(R.font.poppins_regular, FontWeight.Normal),
                        Font(R.font.poppins_medium, FontWeight.Medium),
                        Font(R.font.poppins_semibold, FontWeight.SemiBold),
                        Font(R.font.poppins_bold)
                    )

                    LoginScreen(fontFamily = poppinsFamily)
                }
            }
        }
    }
}