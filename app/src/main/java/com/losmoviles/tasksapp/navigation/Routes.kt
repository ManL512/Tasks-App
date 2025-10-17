package com.losmoviles.tasksapp.navigation

import android.net.Uri

const val TITLE_ARG = "title"

/** Base contract for destinations that accept a title in the route. */
open class Destination(
    val key: String,        // stable id / list key
    val baseRoute: String,  // route prefix
    val defaultTitle: String
) {
    data object Texts : Destination(
        key = "Texts",
        baseRoute = "detail/texts",
        defaultTitle = "Textos de Compose"
    )

    data object Buttons : Destination(
        key = "Buttons",
        baseRoute = "detail/buttons",
        defaultTitle = "Botones de Compose"
    )

    data object Switch : Destination(
        key = "Switch",
        baseRoute = "detail/switch",
        defaultTitle = "Switch de Compose"
    )

    /** Route pattern for NavHost (with arg placeholder). */
    fun pattern(): String = "$baseRoute/{$TITLE_ARG}"

    /** Concrete route for navigate() with encoded title. */
    fun routeWith(title: String = defaultTitle): String =
        "$baseRoute/${Uri.encode(title)}"
}

object Graph {
    const val Home = "home"
}

object Route{

    data object texts  :  Destination("Texts", "detail-texts/Texts", "Textos de compose",)

}