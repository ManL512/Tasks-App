package com.losmoviles.tasksapp.screens

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    CustomScreen(
        title = "Inicio",
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFA3485A))
            ) {
                ContentHomeScreen(navController)
            }
        }
        // Sin onTap: en Home no mostramos botón de atrás
    )
}

@Composable
fun ContentHomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Home",
            color = Color(0xFFF5DAA7)
        )

        Button(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .width(100.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color(0xFF662222),
                containerColor = Color(0xFFF5DAA7) // el primer par (FF) es la opacidad (alpha)
            ),
            onClick = {
                val title = "Mis tareas de hoy"
                val safe = Uri.encode(title)
                navController.navigate("detail-screen/$safe")
            }
        ) {
            Text("Idea")
        }

        Button(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .width(100.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color(0xFF662222),
                containerColor = Color(0xFFF5DAA7) // el primer par (FF) es la opacidad (alpha)
            ),
            onClick = {
                val title = "Mis tareas de hoy"
                val safe = Uri.encode(title)
                navController.navigate("detail-screen/$safe")
            }
        ) {
            Text("Idea")
        }

        Button(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .width(100.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color(0xFF662222),
                containerColor = Color(0xFFF5DAA7) // el primer par (FF) es la opacidad (alpha)
            ),
            onClick = {
                val title = "Mis tareas de hoy"
                val safe = Uri.encode(title)
                navController.navigate("detail-screen/$safe")
            }
        ) {
            Text("Idea")
        }
    }
}
