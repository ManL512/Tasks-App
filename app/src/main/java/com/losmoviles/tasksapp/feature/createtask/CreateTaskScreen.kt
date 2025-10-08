package com.losmoviles.tasksapp.feature.createtask

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.losmoviles.tasksapp.model.activitiesMock
import com.losmoviles.tasksapp.model.daysMock

@Composable
fun CreateTaskUiOnly() {
    Scaffold(
        topBar = { CreateTaskTopBarUi() },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* no funciona, por ahora */ }) {
                Text("+")
            }
        }
    ) { inner ->
        Column(
            modifier = Modifier
                .padding(inner)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            // Selector de días (horizontal)
            LazyRow(
                modifier = Modifier.padding(top = 16.dp, bottom = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(daysMock.size) { index ->
                    DayChipUi(day = daysMock[index])
                }
            }

            // Título de la sección
            Text(
                text = "Chose activity",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Lista de actividades (vertical)
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 96.dp)
            ) {
                items(activitiesMock.size) { index ->
                    ActivityCardUi(activity = activitiesMock[index])
                }
            }
        }
    }
}