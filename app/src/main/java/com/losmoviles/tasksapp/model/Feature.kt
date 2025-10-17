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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri



/**
 * All screens exposed from Home. No magic strings anywhere else.
 * Each item knows its base route, icon and default title.
 */
sealed class Feature(
    val key: String,                  // stable id (used as list key)
    val baseRoute: String,            // NavHost route prefix
    val defaultTitle: String,
    val icon: ImageVector
) {
    data object Texts : Feature(
        key = "Texts",
        baseRoute = "detail-screen",
        defaultTitle = "Textos de Compose",
        icon = Icons.Outlined.Message
    )

    data object Buttons : Feature(
        key = "Buttons",
        baseRoute = "detail-screen-button",
        defaultTitle = "Botones de Compose",
        icon = Icons.Outlined.AdsClick
    )

    data object Switch : Feature(
        key = "Switch",
        baseRoute = "detail-screen-switch",
        defaultTitle = "Switch de Compose",
        icon = Icons.Outlined.ChangeCircle
    )

    data object Radio : Feature(
        key = "Radio Button",
        baseRoute = "detail-screen-radio",
        defaultTitle = "Radio Button de Compose",
        icon = Icons.Filled.Radio
    )

    data object CheckBox : Feature(
        key = "CheckBox",
        baseRoute = "detail-screen-checkbox",
        defaultTitle = "CheckBox de Compose",
        icon = Icons.Rounded.CheckBox
    )

    data object Fab : Feature(
        key = "Floating Action Button",
        baseRoute = "detail-screen-fab",
        defaultTitle = "Floating Action Button",
        icon = Icons.Outlined.AirplanemodeActive
    )
}

/** List used by HomeScreen (order = your menu order). */
val features: List<Feature> = listOf(
    Feature.Texts,
    Feature.Buttons,
    Feature.Switch,
    Feature.Radio,
    Feature.CheckBox,
    Feature.Fab
)

/** Navigation helpers */
const val TITLE_ARG = "title"
fun Feature.pattern(): String = "$baseRoute/{$TITLE_ARG}"
fun Feature.routeWith(title: String = defaultTitle): String =
    "${baseRoute}/${Uri.encode(title)}"

private fun KeyboardType.encode(title: String): String {
    TODO("Not yet implemented")
}
