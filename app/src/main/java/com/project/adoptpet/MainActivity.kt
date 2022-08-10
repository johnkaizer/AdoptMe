package com.project.adoptpet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.project.adoptpet.Data.PetList
import com.project.adoptpet.ui.screen.DetailsScreen
import com.project.adoptpet.ui.screen.Home
import com.project.adoptpet.ui.theme.AdoptPetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdoptPetTheme {
                MyApp()
            }
        }
    }
}
@Composable
fun MyApp(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home"){
        composable(route = "Home"){
            Home(navController)
        }
        composable("details/{dogIndex}", arguments = listOf(navArgument("dogIndex"){type = NavType.IntType})){
            val dogIndex = it.arguments?.getInt("dogIndex") ?: 0
             DetailsScreen(navController, petsData = PetList[dogIndex])
        }
    }

}
