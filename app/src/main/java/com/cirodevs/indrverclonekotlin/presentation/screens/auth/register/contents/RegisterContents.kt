package com.cirodevs.indrverclonekotlin.presentation.screens.auth.register.contents

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
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
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
import com.cirodevs.indrverclonekotlin.presentation.components.DefaultButtom
import com.cirodevs.indrverclonekotlin.presentation.components.DefaultOutlineTextField


@Composable
fun RegisterContents(
     navHostController: NavHostController,paddingValues: PaddingValues
) {
    var email by remember {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("")
    }
    var lastname by remember {
        mutableStateOf("")
    }
    var phone by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmpassword by remember {
        mutableStateOf("")
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
    ){
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ){
            Text(
                text = "Login",
                color = Color.Black,
                fontSize = 27.sp,
                modifier = Modifier
                    .rotate(degrees = 90f)
                    .padding(top = 10.dp)
                    .clickable { navHostController.popBackStack() }
            )
            Spacer(modifier = Modifier.height(150.dp))
            Text(
                text = "Register",
                color = Color.White,
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .rotate(degrees = 90f)
                    .padding(top = 40.dp)
            )

            Spacer(modifier = Modifier.height(250.dp))

        }

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
        ){
            //box content
            Column(
                modifier = Modifier
                    .statusBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally

            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                ){
                    Image(
                        // aqui debemos cambiar la imagen a algo relacionado a un registro
                        modifier = Modifier
                            .size(250.dp)
                            .align(Alignment.Center),
                        painter = painterResource(id = R.drawable.car_white) ,
                        contentDescription = null,
                    )
                }
                //FORMS
                DefaultOutlineTextField(
                    modifier = Modifier,
                    value = name,
                    label = "Nombre",
                    icon = Icons.Outlined.Person,
                    onValueChange ={ name = it }

                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlineTextField(
                    modifier = Modifier,
                    value = lastname,
                    label = "Apellido",
                    icon = Icons.Outlined.Person,
                    onValueChange ={ lastname = it }

                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlineTextField(
                    modifier = Modifier,
                    value = email,
                    label = "Email",
                    icon = Icons.Outlined.Email,
                    keyboardType = KeyboardType.Email,
                    onValueChange ={ email = it }

                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlineTextField(
                    modifier = Modifier,
                    value = phone,
                    label = "Telefono",
                    icon = Icons.Outlined.Phone,
                    keyboardType = KeyboardType.Number,
                    onValueChange ={ phone = it }

                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlineTextField(
                    modifier = Modifier,
                    value = password,
                    label = "Password",
                    icon = Icons.Outlined.Lock,
                    hideText = true,
                    onValueChange ={ password = it }

                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlineTextField(
                    modifier = Modifier,
                    value = confirmpassword,
                    label = "Confirmar password",
                    icon = Icons.Outlined.Lock,
                    hideText = true,
                    onValueChange ={ confirmpassword = it }

                )
                Spacer(modifier = Modifier.weight(1f))

                DefaultButtom(
                    modifier = Modifier,
                    text = "Crear cuenta",
                    onclick = { /*TODO*/ },
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier
                        .width(30.dp)
                        .height(1.dp)
                        .background(color = Color.Black)
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 7.dp),
                        text = "O",
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier
                        .width(30.dp)
                        .height(1.dp)
                        .background(color = Color.Black)
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,

                    ){
                    Text(
                        text = "Ya tienes cuenta?",
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        modifier = Modifier.clickable {navHostController.popBackStack() },
                        text = "Inicia sesion",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,

//                            border = BorderStroke(
//                                width = 1.dp,
//                                color = Color.Black
//                            )
                    )

                }
                Spacer(modifier = Modifier.height(20.dp))

            }
        }
    }
}