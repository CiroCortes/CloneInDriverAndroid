package com.cirodevs.indrverclonekotlin.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cirodevs.indrverclonekotlin.R
import com.cirodevs.indrverclonekotlin.presentation.components.DefaultButtom
import com.cirodevs.indrverclonekotlin.presentation.components.DefaultTextField
import com.cirodevs.indrverclonekotlin.presentation.navigation.screen.auth.AuthScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.auth.login.LoginViewModel


// recordar que aqui pasamos los valores obligatorios nav, paddings
@Composable
fun LoginContents ( navHostController: NavHostController,
                    paddingValues: PaddingValues,
                    vm : LoginViewModel = hiltViewModel()
){
    val state = vm.state
    val context = LocalContext.current // pasamos el contexto porque no se puede llamar directamente en el viewModel
    LaunchedEffect  (key1 = vm.errorMessage) {
        if (vm.errorMessage.isNotEmpty()) {
            // para mostrar el error
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_SHORT).show()
        }
    }
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
                        navHostController.navigate(route = AuthScreen.Register.route)
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
                value = state.email,
                label = "Email",
                icon = Icons.Outlined.Email,
                onValueChange = { vm.onEmailInput(it) },
                hideText = false,
                keyboardType = KeyboardType.Email
            )

            Spacer(modifier = Modifier.height(20.dp))


            DefaultTextField(
                modifier = Modifier,
                value = state.password,
                label = "Password",
                icon = Icons.Outlined.Lock,
                onValueChange = { vm.onPasswordInput(it) },
                hideText = true
            )


            // el peso de 1f es para que ocupe todo el espacio disponible
            Spacer(modifier = Modifier.weight(1f))

            DefaultButtom(
                modifier = Modifier,
                text = "Login",
                onclick = {
                    //Log.d( "Login contents", "Email: ${email}")
                    vm.login()

                },
                color = Color.Black,
                height = 60.dp,
                width = 300.dp
            )

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
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable {
                        navHostController.navigate(route = AuthScreen.Register.route)
                    },
                )
            }
            Spacer(modifier = Modifier.height(70.dp))
        }
    }
}