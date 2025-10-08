package com.losmoviles.tasksapp.services

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.losmoviles.tasksapp.screens.DetailScreen
import com.losmoviles.tasksapp.screens.HomeScreen

@Composable
fun NavigationService(navController: NavHostController){
    NavHost(
        navController= navController,
        startDestination = "home-screen",
    ){
        composable(route= "home-screen"){
            HomeScreen(navController= navController)
        }
        composable(route="detail-screen/{title}", arguments = listOf(
            navArgument(name="title"){
                type = NavType.StringType
            }
        )) {backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: "Desconocido"
            DetailScreen( title= title, navController=navController )
        }
    }
}