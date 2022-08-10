package com.project.adoptpet.ui.screen


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.adoptpet.Data.PetsData
import com.project.adoptpet.ui.theme.deepgreen
import com.project.adoptpet.ui.theme.lightgreen

@Composable
fun DetailsScreen(navController: NavController, petsData: PetsData){
    Scaffold(
        topBar = {
                 TopAppBar(
                     navigationIcon = {
                         IconButton(onClick = { navController.popBackStack() }) {
                             Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = Color.White)
                             
                         }
                     },
                     modifier = Modifier.height(68.dp),
                     title = { Text(text = "Pets", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())},
                     actions = { IconButton(onClick = { /*TODO*/ }) {
                         Icon(imageVector = Icons.Filled.Favorite,contentDescription = null, tint = Color.White)
                         
                     }},
                     elevation = 0.dp,
                     backgroundColor = deepgreen,
                     contentColor = Color.White,

                 )
        },
        bottomBar = {
            Row(Modifier.padding(16.dp)) {
                Button(onClick = { /*TODO*/ },

                    Modifier
                        .fillMaxWidth()
                        .height(53.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = lightgreen),
                    elevation = ButtonDefaults.elevation(0.dp)

                    ) {
                    Text(text = "Adopt Me", style = MaterialTheme.typography.h5)
                    
                }
                
            }
        }
    ) {

    }

}
