package com.cirodevs.indrverclonekotlin.presentation.screens.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cirodevs.indrverclonekotlin.R
import com.cirodevs.indrverclonekotlin.presentation.components.DefaultTextField
import com.cirodevs.indrverclonekotlin.presentation.navigation.screen.auth.AuthScreen


@Composable
fun LoginScreen(navHostController: NavHostController) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Scaffold(
        // esta propiedad es para que el scaffold se adapte a la barra de navegacion
        contentWindowInsets = WindowInsets.navigationBars
    ) { paddingValues -> // siempre usamos paddincalues con el scaffold
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFC7B003), Color(0xFFE5F575)
                        )
                    )
                )
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,

                ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .rotate(degrees = 90f)
                        .padding(top = 10.dp)
                )
                Spacer(modifier = Modifier.height(160.dp))
                Text(
                    text = "Register",
                    color = Color.Black,
                    fontSize = 27.sp,
                    modifier = Modifier
                        .clickable {
                            navHostController.navigate( route= AuthScreen.Register.route)
                        }
                        .rotate(degrees = 90f)
                        .padding(top = 30.dp)
                )
                Spacer(modifier = Modifier.height(250.dp))

            }

        }

        // colocamo otro box para los elemntos del formulario
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 60.dp, bottom = 50.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFF5B906), Color(0xFFF3C751)
                        )
                    ),
                    shape = RoundedCornerShape(
                        topStart = 35.dp,
                        bottomStart = 35.dp
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(start = 25.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Welcome",
                    color = Color.White,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,

                    )
                Text(
                    text = "Back..",
                    color = Color.White,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,

                    )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 25.dp),
                ) {
                    Image(
                        modifier = Modifier
                            .size(180.dp)
                            .align(Alignment.CenterEnd),
                        painter = painterResource(id = R.drawable.car_white),
                        contentDescription = "",
                        alignment = Alignment.Center
                    )
                }
                Text(
                    text = "Log in",
                    color = Color.White,
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    )
                Spacer(modifier = Modifier.height(30.dp))


                DefaultTextField(
                    modifier = Modifier,
                    value = email,
                    label = "Email",
                    icon = Icons.Outlined.Email,
                    onValueChange = { email = it },
                    hideText = false,
                    keyboardType = KeyboardType.Email
                )

                Spacer(modifier = Modifier.height(20.dp))


                DefaultTextField(
                    modifier = Modifier,
                    value = password,
                    label = "Password",
                    icon = Icons.Outlined.Lock,
                    onValueChange = { password = it },
                    hideText = true
                )


                // el peso de 1f es para que ocupe todo el espacio disponible
                Spacer(modifier = Modifier.weight(1f))

                Box(modifier = Modifier
                    .fillMaxWidth()

                ) {
                    Button( modifier = Modifier
                        .align(Alignment.Center)
                        .width(250.dp)
                        .height(55.dp),
                        onClick = {},
                        colors = ButtonDefaults.buttonColors( Color.Black)
                    ) {
                        Text(
                            text = "Login",
                            fontSize = 18.sp,
                            color = Color.White
                            )
                    }

                }
                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Spacer(
                        modifier = Modifier
                            .width(30.dp)
                            .height(1.dp)
                            .background(Color.Black)
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        text = "O",
                        color = Color.Black,
                        fontSize = 20.sp,
                    )
                    Spacer(
                        modifier = Modifier
                            .width(30.dp)
                            .height(1.dp)
                            .background(Color.Black)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "No tienes Cuenta?",
                        color = Color.Black,
                        fontSize = 17.sp,
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Registrate",
                        color = Color.Black,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(70.dp))
            }
        }
    }
}