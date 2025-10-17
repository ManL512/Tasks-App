package com.losmoviles.tasksapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TextsDetailScreen(title: String, navController: NavController){
    CustomScreen(
        title = title,
        content = { TextsContentDetailScreen() },
        onTap = {
            navController.popBackStack()
        }
    )
}

@Composable
fun TextsContentDetailScreen(){
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
            text = "Texto color personalizado y subrayado",
            modifier = Modifier,
            color = Color(0xFFE8DFCA),
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,
        )

        Text(
            text = "Texto con shadow y color verde",
            modifier = Modifier
                .shadow(elevation = 10.dp),
            color = Color(0xFFB0CE88)
        )

        Text(
            text = "Texto más grande y color azul claro",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(lineHeight = 70.sp),
            fontSize = 70.sp,
            color = Color(0xFF73C8D2),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )

    }
}
