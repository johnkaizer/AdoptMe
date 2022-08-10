package com.project.adoptpet.ui.screen

import android.net.wifi.hotspot2.pps.HomeSp
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.adoptpet.Data.PetList
import com.project.adoptpet.Data.PetsData
import com.project.adoptpet.R
import com.project.adoptpet.ui.theme.deepgreen
import com.project.adoptpet.ui.theme.lightgreen

@Composable
fun Home(navController: NavController){
    Scaffold {
       Box(modifier = Modifier
           .background(lightgreen)
           .padding(24.dp)
           .fillMaxWidth()
       ){
           LazyColumn(){
               item {
                   Header()
                   Spacer(modifier = Modifier.height(24.dp))
                   SearchField()
                   Spacer(modifier = Modifier.height(32.dp))
                   Text(text = "New Pets", style = TextStyle(color = White, fontWeight = FontWeight.Bold, fontSize = 20.sp))
                   Spacer(modifier = Modifier.height(12.dp))
               }
               items(PetList.size){
                   item -> PetListItem(item = PetList[item], onCardClick = {
                       item -> navController.navigate("details/${item.id}")
               })
               }
           }
       }
        
    }

}
@Composable
fun Header(name: String ="Johntez"){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(text = "Greeting, $name",
                style = MaterialTheme.typography.h2,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color= White
            )
            Text(text = "We hope you will find a best friend in pets",
                style = MaterialTheme.typography.body1,
                color= White
            )
            
        }
        Icon(
            painter = painterResource(id = R.drawable.pets_24),
            contentDescription = "icon",
            tint =White,
            modifier = Modifier.size(40.dp)
        )

    }

}
@Composable
fun SearchField(){
    val textFieldValue= remember { mutableStateOf("") }
    TextField(value = textFieldValue.value,
        onValueChange = { textFieldValue.value},
        Modifier.fillMaxWidth(),
        textStyle = TextStyle(
            fontSize = 24.sp,
            color = White,

        ),
        maxLines= 1,
        placeholder = {
            Text(
                text = "Search pet here",
                color = White,
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id =R.drawable.search_24 ),
                contentDescription = "search icon",
                tint = White,
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            textColor = White,
        )
    )
}
@Composable
fun PetListItem(item:PetsData, onCardClick:(PetsData) ->Unit){
 Card(backgroundColor = deepgreen,
     modifier = Modifier
         .padding(bottom = 16.dp)
         .clip(RoundedCornerShape(size = 8.dp))
         .background(lightgreen)
         .clickable(onClick = { onCardClick(item) }, enabled = true)
         .padding(2.dp),
     elevation =0.dp) {
     Column(Modifier.padding(8.dp)){
         Box(
             Modifier
                 .fillMaxWidth()
                 .height(200.dp)
                 .clip(shape = RoundedCornerShape(6.dp))
                 .background(color = Color.Gray),
             Alignment.Center
         ) {
             Image(
                 painter = painterResource(id = item.imagePath),
                 contentDescription = null,
                 contentScale = ContentScale.Crop,
                 modifier = Modifier.fillMaxSize()
             )
         }
         
             Spacer(modifier = Modifier.height(4.dp))
             Text(item.name, style = TextStyle(color=Color.White, fontWeight = FontWeight.Bold, fontSize = 22.sp))
         PetsDetails(age = item.age, weight = item.weight)


     }

 }

}
@Composable
fun PetsDetails(age:Int, weight:Double){
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Column (
            Modifier
                .weight(1F)
                .align(Alignment.CenterVertically)
                ){
            val year =if (age > 1) "years" else "year"
            Text(text ="Age", style = TextStyle(
                color =Color(0xaaFFFFFF),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,

            ),
            textAlign = TextAlign.Center
                )
            Text(text = "$age $year", textAlign = TextAlign.Center, color =Color(0xFFdfdfdf))

        }
        Column (
            Modifier
                .weight(1F)
                .align(Alignment.CenterVertically)
        ){
            val year =if (age > 1) "years" else "year"
            Text(text ="Weight", style = TextStyle(
                color =Color(0xaaFFFFFF),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,

                ),
                textAlign = TextAlign.Center
            )
            Text(text = "$weight kg", textAlign = TextAlign.Center, color =Color(0xFFdfdfdf))

        }

        
    }
}