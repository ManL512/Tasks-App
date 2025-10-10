package com.losmoviles.tasksapp.services

import ButtonsDetailScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.losmoviles.tasksapp.screens.TextsDetailScreen
import com.losmoviles.tasksapp.screens.HomeScreen
import com.losmoviles.tasksapp.screens.SwitchContentDetailScreen

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
            TextsDetailScreen( title= title, navController=navController )
        }

        composable(route="detail-screen-button/{title}", arguments = listOf(
            navArgument(name="title"){
                type = NavType.StringType
            }
        )) {backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: "Desconocido"
            ButtonsDetailScreen( title= title, navController=navController )
        }

        composable(route="detail-screen-switch/{title}", arguments = listOf(
            navArgument(name="title"){
                type = NavType.StringType
            }
        )) {backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: "Desconocido"
            SwitchContentDetailScreen( title= title, navController=navController )
        }
    }
}
