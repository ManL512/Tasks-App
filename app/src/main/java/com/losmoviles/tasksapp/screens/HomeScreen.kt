package com.losmoviles.tasksapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController){
    CustomScreen(
        title = "Composables App",
        content = {ContentHomeScreen(navController)}
    )
}

@Composable
fun ContentHomeScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize().padding(12.dp)

    )  {
        Button(onClick = {
            val title = "Texts"
            navController.navigate(route="detail-screen/$title")
        }) {
            Text(text = "Navegar a detalle")
        }
    }
}