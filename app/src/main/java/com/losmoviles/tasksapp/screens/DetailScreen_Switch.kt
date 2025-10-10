package com.losmoviles.tasksapp.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun SwitchContentDetailScreen(title: String, navController: NavHostController) {
    val context = LocalContext.current

    // Estados de cada switch
    var switchBasic by remember { mutableStateOf(false) }
    var switchColored by remember { mutableStateOf(false) }
    var switchWithLabel by remember { mutableStateOf(false) }
    var switchDisabled by remember { mutableStateOf(false) }
    var switchDynamicText by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // --- 1. Switch básico ---
        androidx.compose.material3.Switch(
            checked = switchBasic,
            onCheckedChange = {
                switchBasic = it
                Toast.makeText(context, "Switch básico: $it", Toast.LENGTH_SHORT).show()
            }
        )
        Text(text = "Switch básico: ${if (switchBasic) "Activado" else "Desactivado"}")

        // --- 2. Switch con colores personalizados ---
        androidx.compose.material3.Switch(
            checked = switchColored,
            onCheckedChange = {
                switchColored = it
                Toast.makeText(context, "Switch color: $it", Toast.LENGTH_SHORT).show()
            },
            colors = androidx.compose.material3.SwitchDefaults.colors(
                checkedThumbColor = Color(0xFF4CAF50),
                checkedTrackColor = Color(0xFF81C784),
                uncheckedThumbColor = Color(0xFFBDBDBD),
                uncheckedTrackColor = Color(0xFFE0E0E0)
            )
        )
        Text(text = "Switch con color personalizado")

        // --- 3. Switch con texto descriptivo ---
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Notificaciones Push")
            androidx.compose.material3.Switch(
                checked = switchWithLabel,
                onCheckedChange = {
                    switchWithLabel = it
                    Toast.makeText(context, "Notificaciones: $it", Toast.LENGTH_SHORT).show()
                }
            )
        }

        // --- 4. Switch deshabilitado ---
        androidx.compose.material3.Switch(
            checked = switchDisabled,
            onCheckedChange = {},
            enabled = false
        )
        Text(text = "Switch deshabilitado (sin interacción)")

        // --- 5. Switch con texto dinámico ---
        androidx.compose.material3.Switch(
            checked = switchDynamicText,
            onCheckedChange = { switchDynamicText = it }
        )
        Text(
            text = if (switchDynamicText) "Modo oscuro activado 🌙"
            else "Modo claro ☀️"
        )
    }
}
