package com.losmoviles.tasksapp.screens

import CustomScreen
import android.widget.Switch
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
fun SwitchDetailScreen(
    navController: NavHostController,
    title: String = "Ejemplos de Switch"
) {
    CustomScreen(
        title = title,
        onTap = { navController.popBackStack() },
        backgroundColor = Color(0xFFB4DEBD),
        content = {                    // <-- NÓMBRALO
            SwitchDetailBody()
        }
    )
}

@Composable
private fun SwitchDetailBody() {
    val context = LocalContext.current

    var switchBasic by remember { mutableStateOf(false) }
    var switchColored by remember { mutableStateOf(false) }
    var switchWithLabel by remember { mutableStateOf(false) }
    var switchDisabled by remember { mutableStateOf(false) }
    var switchDynamicText by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1) Básico
        Switch(
            checked = switchBasic,
            onCheckedChange = {
                switchBasic = it
                Toast.makeText(context, "Switch básico: $it", Toast.LENGTH_SHORT).show()
            }
        )
        Text("Switch básico: ${if (switchBasic) "Activado" else "Desactivado"}")

        // 2) Colores personalizados
        Switch(
            checked = switchColored,
            onCheckedChange = {
                switchColored = it
                Toast.makeText(context, "Switch color: $it", Toast.LENGTH_SHORT).show()
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color(0xFF4CAF50),
                checkedTrackColor = Color(0xFF81C784),
                uncheckedThumbColor = Color(0xFFBDBDBD),
                uncheckedTrackColor = Color(0xFFE0E0E0)
            )
        )
        Text("Switch con color personalizado")

        // 3) Con texto descriptivo
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Notificaciones Push")
            Switch(
                checked = switchWithLabel,
                onCheckedChange = {
                    switchWithLabel = it
                    Toast.makeText(context, "Notificaciones: $it", Toast.LENGTH_SHORT).show()
                }
            )
        }

        // 4) Deshabilitado
        Switch(
            checked = switchDisabled,
            onCheckedChange = {},
            enabled = false
        )
        Text("Switch deshabilitado (sin interacción)")

        // 5) Texto dinámico
        Switch(
            checked = switchDynamicText,
            onCheckedChange = { switchDynamicText = it }
        )
        Text(if (switchDynamicText) "Modo oscuro activado 🌙" else "Modo claro ☀️")
    }
}