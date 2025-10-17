package com.losmoviles.tasksapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonsDetailScreen(title: String) {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = title)
        Spacer(Modifier.height(12.dp))
        var count by remember { mutableStateOf(0) }
        Button(onClick = { count++ }) { Text("Clicks: $count") }
    }
}
