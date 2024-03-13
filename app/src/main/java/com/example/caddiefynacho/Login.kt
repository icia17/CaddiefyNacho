package com.example.caddiefynacho

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
fun LoginScreen(fontFamily: FontFamily) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.Caddiefy_Background)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.caddiefy_logo_full),
            contentDescription = "FullLogo",
            modifier = Modifier
                .padding(bottom = 48.dp)
                .fillMaxWidth(.42f)
                .fillMaxHeight(.19f)
        )
        LoginTextField(fontFamily, "Usuario", Icons.Outlined.Person)
        LoginTextField(fontFamily, "Contraseña", Icons.Outlined.Lock)
        Spacer(modifier = Modifier.height(120.dp))
    }
}

@Composable
fun LoginTextField(fontFamily: FontFamily, initValue: String, iconImage: ImageVector) {

    var textValue by rememberSaveable {
        mutableStateOf("")
    }
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = interactionSource.collectIsFocusedAsState().value

    Column(
        modifier = Modifier
            .fillMaxWidth(.8f)
            .padding(bottom = 40.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = iconImage,
                contentDescription = "User",
                modifier = Modifier.size(30.dp),
                tint = colorResource(id = R.color.Caddiefy_Button)
            )
            BasicTextField(
                value = textValue,
                onValueChange = { textValue = it },
                modifier = Modifier.weight(1f),
                singleLine = true,
                interactionSource = interactionSource,
            ) {
                Row {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = if (isFocused) textValue else initValue,
                        color = Color.White,
                        fontSize = 15.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Light,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
            Spacer(modifier = Modifier.size(30.dp))
        }
        Divider(
            color = Color.White,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun MainPreview2() {
    CaddiefyNachoTheme {
        val poppinsFamily = FontFamily(
            Font(R.font.poppins_light, FontWeight.Light),
            Font(R.font.poppins_regular, FontWeight.Normal),
            Font(R.font.poppins_medium, FontWeight.Medium),
            Font(R.font.poppins_semibold, FontWeight.SemiBold),
            Font(R.font.poppins_bold, FontWeight.Bold)
        )

        LoginScreen(poppinsFamily)
    }
}