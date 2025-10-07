package com.losmoviles.tasksapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Fastfood
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material.icons.outlined.Work
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                CreateTaskUiOnly() // <- solo UI, sin funcionalidades
            }
        }
    }
}
// -------------------- DATA MOCK (estático, sin lógica) --------------------

private val daysMock = listOf(
    DayUi(5, "Mon", selected = true),
    DayUi(6, "Tue"),
    DayUi(7, "Wed"),
    DayUi(8, "Thu"),
    DayUi(9, "Fri"),
    DayUi(10, "Sat"),
    DayUi(11, "Sun"),
)

private val activitiesMock = listOf(
    ActivityUi("Idea",  "13 on this week", Icons.Outlined.Lightbulb),
    ActivityUi("Food",  "8 on this week",  Icons.Outlined.Fastfood),
    ActivityUi("Work",  "15 on this week", Icons.Outlined.Work),
    ActivityUi("Sport", "7 on this week",  Icons.Outlined.FitnessCenter),
    ActivityUi("Music", "24 on this week", Icons.Outlined.MusicNote),
)

private data class DayUi(
    val number: Int,
    val short: String,
    val selected: Boolean = false
)
private data class ActivityUi(
    val title: String,
    val subtitle: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)

// -------------------- SCREEN --------------------

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

// -------------------- TOP BAR --------------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CreateTaskTopBarUi() {
    TopAppBar(
        title = {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu")
                Text("Create Task", style = MaterialTheme.typography.titleMedium)
                Icon(Icons.Filled.Settings, contentDescription = "Settings")
            }
        }
    )
}

// -------------------- DAY CHIP (estático) --------------------

@Composable
private fun DayChipUi(day: DayUi) {
    val bg = if (day.selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
    val fg = if (day.selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
    Surface(
        color = bg,
        shape = RoundedCornerShape(16.dp),
        tonalElevation = if (day.selected) 4.dp else 1.dp
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("${day.number}", color = fg, fontWeight = FontWeight.SemiBold)
            Text(day.short, color = fg, fontSize = 12.sp)
        }
    }
}

// -------------------- ACTIVITY CARD (estático) --------------------

@Composable
private fun ActivityCardUi(activity: ActivityUi) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        tonalElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icono dentro de un contenedor redondo suave
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                contentAlignment = Alignment.Center
            ) {
                Icon(activity.icon, contentDescription = null)
            }

            Spacer(Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(activity.title, style = MaterialTheme.typography.titleMedium)
                Text(
                    activity.subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Icon(Icons.Filled.ChevronRight, contentDescription = null)
        }
    }
}

// -------------------- PREVIEW --------------------

@Preview(showBackground = true)
@Composable
private fun PreviewCreateTaskUiOnly() {
    MaterialTheme {
        CreateTaskUiOnly()
    }
}