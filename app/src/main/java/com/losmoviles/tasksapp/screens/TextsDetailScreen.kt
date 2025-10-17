package com.losmoviles.tasksapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TextsDetailScreen(title: String) {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = title)
        Spacer(Modifier.height(12.dp))
        Text("Aquí irían ejemplos y explicaciones sobre Text composable.")
    }
}
