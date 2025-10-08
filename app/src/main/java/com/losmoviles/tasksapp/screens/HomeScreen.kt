package com.losmoviles.tasksapp.screens

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    CustomScreen(
        title = "Inicio",
        content = { ContentHomeScreen(navController) }
        // Sin onTap: en Home no mostramos botón de atrás
    )
}

@Composable
fun ContentHomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home")

        Button(
            onClick = {
                val title = "Mis tareas de hoy"
                val safe = Uri.encode(title)
                navController.navigate("detail-screen/$safe")
            }
        ) {
            Text("Idea")
        }

        Button(
            onClick = {
                val title = "Mis tareas de hoy"
                val safe = Uri.encode(title)
                navController.navigate("detail-screen/$safe")
            }
        ) {
            Text("Food")
        }

        Button(
            onClick = {
                val title = "Mis tareas de hoy"
                val safe = Uri.encode(title)
                navController.navigate("detail-screen/$safe")
            }
        ) {
            Text("Work")
        }
    }
}
