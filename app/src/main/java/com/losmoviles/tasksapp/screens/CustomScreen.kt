package com.losmoviles.tasksapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.losmoviles.tasksapp.services.NavigationService

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun CustomScreen(title: String, content:  @Composable () -> Unit, onTap:  (() -> Unit)? = null){
    Scaffold(
        topBar = {
            TopAppBar(
                title ={ Text(text = title) }, navigationIcon = {
                    if(onTap !=null){
                        TextButton(onClick = onTap) {Text("Atras") }
                    }
                }
            )
        }
    )
    {paddingValues ->
        Box (modifier = Modifier.padding(paddingValues)) {content()}
    }
}