package com.losmoviles.tasksapp.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Fastfood
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material.icons.outlined.Work

// -------------------- DATA CLASS (estático, sin lógica) --------------------

val daysMock = listOf(
    DayUi(5, "Mon", selected = true),
    DayUi(6, "Tue"),
    DayUi(7, "Wed"),
    DayUi(8, "Thu"),
    DayUi(9, "Fri"),
    DayUi(10, "Sat"),
    DayUi(11, "Sun"),
)

val activitiesMock = listOf(
    ActivityUi("Idea",  "13 on this week", Icons.Outlined.Lightbulb),
    ActivityUi("Food",  "8 on this week",  Icons.Outlined.Fastfood),
    ActivityUi("Work",  "15 on this week", Icons.Outlined.Work),
    ActivityUi("Sport", "7 on this week",  Icons.Outlined.FitnessCenter),
    ActivityUi("Music", "24 on this week", Icons.Outlined.MusicNote),
)

data class DayUi(
    val number: Int,
    val short: String,
    val selected: Boolean = false
)
data class ActivityUi(
    val title: String,
    val subtitle: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)