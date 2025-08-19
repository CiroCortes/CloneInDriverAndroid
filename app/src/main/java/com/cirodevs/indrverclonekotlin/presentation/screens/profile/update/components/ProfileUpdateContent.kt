package com.cirodevs.indrverclonekotlin.presentation.screens.profile.update.components


import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.cirodevs.indrverclonekotlin.presentation.components.DefaultTextField
import com.cirodevs.indrverclonekotlin.presentation.components.DialogCameraOrGallery
import com.cirodevs.indrverclonekotlin.presentation.navigation.screen.profile.ProfileScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.profile.info.ProfileInfoViewModel
import com.cirodevs.indrverclonekotlin.presentation.screens.profile.update.ProfileUpdateViewModel
import com.cirodevs.indrverclonekotlin.ui.theme.InDriverCloneKotlinTheme

@Composable
fun ProfileUpdateContent(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    vm: ProfileUpdateViewModel = hiltViewModel()
) {

    val activity = LocalContext.current as Activity?
    val state = vm.state
    vm.resultingActivityHandler.handle()
    val stateDialog = remember {
        mutableStateOf(false)
    }

   DialogCameraOrGallery(
       state = stateDialog,
       takePhoto = {vm.takePhoto()},
       pickImage = {vm.pickImage()},
   )



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
                title = "ACTUALIZAR PERFIL",
                imageVector = Icons.Default.Edit,
                onClick = {

                    vm.submit()
                }

            )


        }
        // data of the user
       Card(
           modifier = Modifier
               .fillMaxWidth()
               .fillMaxHeight(0.7f)
               .padding(horizontal = 20.dp, vertical = 100.dp),
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
               if (!state.image.isNullOrBlank()) { // not null or not void
                   AsyncImage(
                       modifier = Modifier
                           .size(130.dp)
                           .clip(CircleShape)
                           .align(Alignment.CenterHorizontally)
                           .clickable {
                           stateDialog.value = true
                       },
                       model = state.image,
                       contentDescription = null,
                       contentScale = ContentScale.Crop // this property crop the image (adapt to father box)
                   )

               }else {
                   Image(
                       modifier = Modifier
                           .size(130.dp)
                           .clip(CircleShape)
                           .align(Alignment.CenterHorizontally)
                           .clickable {
                               stateDialog.value = true
                       },
                       painter = painterResource(id = R.drawable.user_image),
                       contentDescription = null
                   )
               }
               Spacer(modifier = Modifier.height(20.dp))
               // text name
               DefaultTextField(
                   modifier = Modifier.fillMaxWidth(),
                   value = state.name,
                   label = "Nombre",
                   icon = Icons.Default.Person ,
                   onValueChange ={
                       vm.onNameInput(it)

                   }
               )

               DefaultTextField(
                   modifier = Modifier.fillMaxWidth(),
                   value = state.lastname,
                   label = "Apellido",
                   icon = Icons.Outlined.Person ,
                   onValueChange ={
                       vm.onLastNameInput(it)

                   }
               )
               DefaultTextField(
                   modifier = Modifier.fillMaxWidth(),
                   value = state.phone,
                   label = "Telefono",
                   icon = Icons.Default.Phone ,
                   onValueChange ={
                       vm.onPhoneInput(it)

                   }
               )


           }
       }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    InDriverCloneKotlinTheme {
        ProfileUpdateContent(rememberNavController(), PaddingValues())
    }

}