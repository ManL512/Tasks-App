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
    ActivityUi("Texts", Icons.Outlined.Message),
    ActivityUi("Buttons", Icons.Outlined.AdsClick),
    ActivityUi("Switch", Icons.Outlined.ChangeCircle),
    ActivityUi("Radio Button", Icons.Filled.Radio),
    ActivityUi("CheckBox", Icons.Rounded.CheckBox),
    ActivityUi("Floating Action Button", Icons.Outlined.AirplanemodeActive),
)

// -------------------- DATA CLASS (estático, sin lógica) --------------------

data class ActivityUi(
    val route: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)