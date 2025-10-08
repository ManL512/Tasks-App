package com.losmoviles.tasksapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
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
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )  {
            Text(text = "Texto base")
//            Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Texto color personalizado",
            modifier = Modifier,
            color = Color(0xFFE8DFCA),
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,
        )
    }
}
