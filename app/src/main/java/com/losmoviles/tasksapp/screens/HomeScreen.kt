package com.losmoviles.tasksapp.screens

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.losmoviles.tasksapp.feature.createtask.ActivityCardUi
import com.losmoviles.tasksapp.model.activitiesMock
import CustomScreen

@Composable
fun HomeScreen(navController: NavController) {
    CustomScreen(
        title = "Inicio",
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFA3485A))
                    .padding(top = 20.dp)
            ) {
                ContentHomeScreen(navController)
            }
        }
        // Sin onTap: en Home no mostramos botón de atrás
    )
}

@Composable
fun ContentHomeScreen(navController: NavController) {
//    Spacer(modifier = Modifier.height(200.dp))
    // Lista vertical
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(bottom = 96.dp)
    ) {
        items(activitiesMock.size) { index ->
            val item = activitiesMock[index]
            ActivityCardUi(activity = item) {
                // Decide qué hacer con el click.
                when (item.title) {
                    "Texts" -> {
                        val title = "Textos de Compose"
                        val safe = Uri.encode(title)
                        navController.navigate("detail-screen/$safe")
                    }
                    "Buttons" -> {
                        val title = "Botones de Compose"
                        val safe = Uri.encode(title)
                        navController.navigate("detail-screen-button/$safe")
                    }
                    "Switch" -> {
                        val title = "Cards de Compose"
                        val safe = Uri.encode(title)
                        navController.navigate("detail-screen/$safe")
                    }
                }
            }
        }
    }
}
