package com.losmoviles.tasksapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.losmoviles.tasksapp.ui.components.ActivityCard
import com.losmoviles.tasksapp.model.Feature
import com.losmoviles.tasksapp.model.features


private val HomeTopPadding = 20.dp
private val ListItemSpacing = 12.dp
private val ListBottomPadding = 96.dp
private val HomeBackground = Color(0xFFA3485A)

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(HomeBackground)
            .padding(top = HomeTopPadding, start = 16.dp, end = 16.dp)
    ) {
        FeatureList(
            items = features,
navController= navController
        )
    }
}

@Composable
private fun FeatureList(
    items: List<Feature>,
    navController: NavController
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(ListItemSpacing),
        contentPadding = PaddingValues(bottom = ListBottomPadding),
        modifier = Modifier.fillMaxSize()
    ) {
        items(items, key = { it.key }) { feature ->
            ActivityCard(
                title = feature.title,
                subtitle = feature.subtitle,
                icon = feature.icon,
                onClick = {
                    val title = feature.title
                    navController.navigate(route="${feature.destination.baseRoute}/$title")
                }
            )
        }
    }
}