package com.losmoviles.tasksapp.services
import ButtonsDetailScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.losmoviles.tasksapp.screens.*
import com.losmoviles.tasksapp.model.*

@Composable
fun NavigationService(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home-screen"
    ) {
        composable("home-screen") {
            HomeScreen(navController)
        }

        // Bind each Feature to its destination pattern
        composable(
            route = Feature.Texts.pattern(),
            arguments = listOf(navArgument(TITLE_ARG) { type = NavType.StringType })
        ) { backStack ->
            val title = backStack.arguments?.getString(TITLE_ARG) ?: Feature.Texts.defaultTitle
            TextsDetailScreen(title = title, navController = navController)
        }

        composable(
            route = Feature.Buttons.pattern(),
            arguments = listOf(navArgument(TITLE_ARG) { type = NavType.StringType })
        ) { backStack ->
            val title = backStack.arguments?.getString(TITLE_ARG) ?: Feature.Buttons.defaultTitle
            ButtonsDetailScreen(title = title, navController = navController)
        }

        composable(
            route = Feature.Switch.pattern(),
            arguments = listOf(navArgument(TITLE_ARG) { type = NavType.StringType })
        ) { backStack ->
            val title = backStack.arguments?.getString(TITLE_ARG) ?: Feature.Switch.defaultTitle
            SwitchDetailScreen(title = title, navController = navController)
        }

        // Optional: wire the rest when you have screens
        // composable(Feature.Radio.pattern(),   ...) { /* RadioDetailScreen */ }
        // composable(Feature.CheckBox.pattern(),...) { /* CheckBoxDetailScreen */ }
        // composable(Feature.Fab.pattern(),     ...) { /* FabDetailScreen */ }
    }
}
