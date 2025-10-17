package com.losmoviles.tasksapp.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Message
import androidx.compose.material.icons.filled.Radio
import androidx.compose.material.icons.outlined.AdsClick
import androidx.compose.material.icons.outlined.AirplanemodeActive
import androidx.compose.material.icons.outlined.ChangeCircle
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.rounded.CheckBox
import androidx.compose.ui.graphics.vector.ImageVector
import com.losmoviles.tasksapp.navigation.Destination


data class Feature(
    val destination: Destination,
    val icon: ImageVector,
    val subtitle: String = destination.defaultTitle
) {
    val key: String get() = destination.key
    val title: String get() = destination.key
}

val features: List<Feature> = listOf(
    Feature(destination =Destination(
        key = "Texts",
        baseRoute = "detail-texts",
        defaultTitle = "Textos de Compose"
    ),   icon = Icons.Outlined.Message),
//    Feature(destination = Destination.Buttons, icon = Icons.Outlined.AdsClick),
//    Feature(destination = Destination.Switch,  icon = Icons.Outlined.ChangeCircle),
//
//    // Extend safely as you add screens:
//    Feature(destination = Destination.Texts,   icon = Icons.Filled.Radio, subtitle = "Radio Button (coming soon)"),
//    Feature(destination = Destination.Texts,   icon = Icons.Rounded.CheckBox, subtitle = "CheckBox (coming soon)"),
//    Feature(destination = Destination.Texts,   icon = Icons.Outlined.AirplanemodeActive, subtitle = "FAB (coming soon)")
)