package com.losmoviles.tasksapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.losmoviles.tasksapp.screens.ButtonsDetailScreen
import com.losmoviles.tasksapp.screens.TextsDetailScreen
import com.losmoviles.tasksapp.screens.SwitchDetailScreen
import com.losmoviles.tasksapp.screens.HomeScreen


@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Graph.Home,
        modifier = modifier
    ) {
        composable(Graph.Home) {
            HomeScreen(navController)
        }

        composable(
            route = "detail-text/{title}",
            arguments = listOf(navArgument("title") { type = NavType.StringType })
        ) { backStack ->
            val title = backStack.arguments?.getString("title") ?: "Desconocido"
            TextsDetailScreen(title = title)
        }

        composable(
            route = "detail-buttons/{title}",
            arguments = listOf(navArgument("title") { type = NavType.StringType })
        ) { backStack ->
            val title = backStack.arguments?.getString("title") ?: "Desconocido"
            ButtonsDetailScreen(title = title)
        }

        composable(
            route = "detail-switch/{title}",
            arguments = listOf(navArgument("title") { type = NavType.StringType })
        ) { backStack ->
            val title = backStack.arguments?.getString("title") ?: "Desconocido"
            SwitchDetailScreen(title = title)
        }
    }
}
