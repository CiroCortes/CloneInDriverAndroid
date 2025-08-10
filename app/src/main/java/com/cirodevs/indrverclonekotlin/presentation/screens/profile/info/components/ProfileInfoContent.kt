package com.cirodevs.indrverclonekotlin.presentation.screens.profile.info.components


import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.cirodevs.indrverclonekotlin.MainActivity

import com.cirodevs.indrverclonekotlin.R
import com.cirodevs.indrverclonekotlin.presentation.components.DefaultIconButton
import com.cirodevs.indrverclonekotlin.presentation.navigation.screen.profile.ProfileScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.profile.info.ProfileInfoViewModel
import com.cirodevs.indrverclonekotlin.ui.theme.InDriverCloneKotlinTheme

@Composable
fun ProfileInfoContent(navHostController: NavHostController, paddingValues: PaddingValues, vm: ProfileInfoViewModel = hiltViewModel()) {

    val activity = LocalContext.current as Activity?

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)) {
        // the column content all components of the screen
        Column {
            // the will be content a blue gradient background , and text with a button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFFC7B003), Color(0xFFE5F575)
                            )
                        )
                    ),
                contentAlignment = Alignment.TopCenter
            ) {
                Text(
                    text = "PERFIL DE USUARIO",
                    modifier = Modifier.padding(top = 40.dp),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 19.sp

                )
            }
            Spacer(modifier = Modifier.weight(1f))
            // it here a icons and text with a button, created with a box
            // row edit profile
            DefaultIconButton(
                modifier = Modifier,
                title = "EDITAR PERFIL",
                imageVector = Icons.Default.Edit,
                onClick = {
                    if (vm.user != null) {
                        navHostController.navigate(
                            route = ProfileScreen.ProfileUpdate.passUser(vm.user!!.toJson())
                        )
                    }
                }

            )
            Spacer(modifier = Modifier.height(20.dp))
            DefaultIconButton(
                modifier = Modifier,
                title = "CERRAR SESIÓN",
                imageVector = Icons.Default.ExitToApp,
                onClick = {
                    vm.logout()
                    // this action close the activity and restart to main
                    activity?.finish()
                    activity?.startActivity(Intent(activity, MainActivity::class.java))
                }


            )
        }
        // data of the user
       Card(
           modifier = Modifier
               .fillMaxWidth()
               .fillMaxHeight(0.6f)
               .padding(horizontal = 20.dp,vertical = 100.dp),
           colors = CardDefaults.cardColors(
               containerColor = Color.White),
           // elevation is the shadow border effect
           elevation = CardDefaults.cardElevation(
               defaultElevation = 10.dp
           )

       ){
           Column (
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(25.dp),
               horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.Center
           ) {
               Box(
                   modifier = Modifier
                       .padding(top = 5.dp)
                       .size(150.dp)
                       .clip(CircleShape)
                       .background(Color.White)
               ) {
                   if (!vm.user?.image.isNullOrBlank()) { // not null or not void
                      AsyncImage(
                          model = vm.user?.image,
                          contentDescription = null,
                          contentScale = ContentScale.Crop // this property crop the image (adapt to father box)
                      )

                   }else {
                       Image(
                           painter = painterResource(id = R.drawable.user_image),
                           contentDescription = null
                       )
                   }

               }
               Spacer(modifier = Modifier.height(20.dp))
               // text name
               Text(
                   text = "${vm.user?.name} ${vm.user?.lastname}",
                   fontWeight = FontWeight.Bold,
                   fontSize = 20.sp
               )

               // text email
               Text(
                   text = vm.user?.email ?: "",
                   fontSize = 18.sp

               )
               // text phone
               Text(
                   text = vm.user?.phone ?: "",
                   fontSize = 18.sp
               )
           }
       }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    InDriverCloneKotlinTheme {
        ProfileInfoContent(rememberNavController(), PaddingValues())
    }

}