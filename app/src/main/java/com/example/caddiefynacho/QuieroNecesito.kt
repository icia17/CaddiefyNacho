package com.example.caddiefynacho

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caddiefynacho.ui.theme.CaddiefyNachoTheme


@Composable
fun QuieroNecesito(fontFamily: FontFamily) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.Caddiefy_Background)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.caddiefy_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(131.dp)
                    .height(123.dp)
            )
            CaddieButton(text = "Quiero ser caddie", fontFamily = fontFamily)
            CaddieButton(text = "Necesito un caddie", fontFamily = fontFamily)
        }
    }
}

@Composable
fun CaddieButton(text: String, fontFamily: FontFamily) {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .padding(
                top = 26.dp,
                bottom = 4.dp
            )
            .width(300.dp)
            .height(49.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.Caddiefy_Button)
        )
    ) {
        Text(
            text = text,
            fontSize = 24.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    CaddiefyNachoTheme {
        val poppinsFamily = FontFamily(
            Font(R.font.poppins_light, FontWeight.Light),
            Font(R.font.poppins_regular, FontWeight.Normal),
            Font(R.font.poppins_medium, FontWeight.Medium),
            Font(R.font.poppins_semibold, FontWeight.SemiBold),
            Font(R.font.poppins_bold, FontWeight.Bold)
        )

        QuieroNecesito(poppinsFamily)
    }
}