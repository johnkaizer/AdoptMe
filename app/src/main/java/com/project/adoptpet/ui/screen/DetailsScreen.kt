package com.project.adoptpet.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
                    Text(text = "Adopt Me", style = MaterialTheme.typography.h5, color = Color.White)
                    
                }
                
            }
        },
        backgroundColor = deepgreen,
        contentColor = Color.White
    ) {
        Body(Modifier.padding(16.dp), petsData = petsData)

    }

}
@Composable
fun Body(modifier: Modifier,petsData: PetsData){
    Column(modifier = modifier) {
        Box(
            modifier
                .fillMaxWidth()
                .height(280.dp)
                .clip(shape = RoundedCornerShape(8.dp))

        ){
            Image(painter = painterResource(id = petsData.imagePath), contentDescription = null, contentScale = ContentScale.Crop,modifier= Modifier.fillMaxWidth())
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(petsData.name, style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(12.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
            val mod = Modifier
                .clip(shape = RoundedCornerShape(size = 8.dp))
                .weight(1f)
                .background(lightgreen)
                .padding(all = 8.dp)
            
            DetailsBox(title ="Gender" , info = "${petsData.gender}", mod )
            Spacer(modifier = Modifier.width(6.dp))
            DetailsBox(title ="Age" , info = "${petsData.age}", mod )
            Spacer(modifier = Modifier.width(6.dp))
            DetailsBox(title ="Weight" , info = "${petsData.weight}", mod )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Summary", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(6.dp))
        Text(text = "The most beautiful pet you have ever seen?", style = MaterialTheme.typography.body2)
    }

}
@Composable
fun DetailsBox(title:String, info:String, modifier: Modifier){
    Box(modifier = modifier){
        Column() {
            Text(text = title, Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Text(text = info, Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            
        }
    }
}
