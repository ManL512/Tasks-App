package com.losmoviles.tasksapp.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Radio
import androidx.compose.material.icons.outlined.AdsClick
import androidx.compose.material.icons.outlined.AirplanemodeActive
import androidx.compose.material.icons.outlined.ArrowRight
import androidx.compose.material.icons.outlined.ChangeCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Tv
import androidx.compose.material.icons.rounded.CheckBox
import androidx.compose.material.icons.rounded.Favorite


val activitiesMock = listOf(
    ActivityUi("Texts",  "13 on this week", Icons.Outlined.Message),
    ActivityUi("Buttons",  "8 on this week",  Icons.Outlined.AdsClick),
    ActivityUi("Switch",  "2 on this week", Icons.Outlined.ChangeCircle),
    ActivityUi("Radio Button",   "13 on this week", Icons.Filled.Radio),
    ActivityUi("CheckBox", "8 on this week",  Icons.Rounded.CheckBox),
    ActivityUi("Floating Action Button",   "15 on this week", Icons.Outlined.AirplanemodeActive),
)

// -------------------- DATA CLASS (estático, sin lógica) --------------------

data class ActivityUi(
    val title: String,
    val route: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)