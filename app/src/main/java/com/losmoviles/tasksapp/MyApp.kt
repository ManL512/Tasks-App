package com.losmoviles.tasksapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.losmoviles.tasksapp.services.NavigationService

@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavigationService(navController)
}