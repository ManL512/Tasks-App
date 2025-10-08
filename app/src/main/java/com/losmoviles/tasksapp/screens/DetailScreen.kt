package com.losmoviles.tasksapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailScreen(title: String, navController: NavController){
    CustomScreen(
        title = title,
        content = { ContentDetailScreen()},
        onTap = {
            navController.popBackStack()
        }
    )
}

@Composable
fun ContentDetailScreen(){
    Column(
        modifier = Modifier.fillMaxSize().padding(12.dp)
    )  {
            Text(text = "Navegar ")
    }
}