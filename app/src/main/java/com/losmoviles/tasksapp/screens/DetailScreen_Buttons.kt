import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import CustomScreen
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import java.time.LocalDateTime

@Composable
fun ButtonsDetailScreen(title: String, navController: NavController){
    CustomScreen(
        title = title,
        content = { ButtonsContentDetailScreen()},

        onTap = {
            navController.popBackStack()
        },
        Color(0xFFB4DEBD)
    )
}

@Composable
fun ButtonsContentDetailScreen() {
    val context = LocalContext.current
    var isClicked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // --- 1. Botón básico ---
        Button(onClick = {
            Toast.makeText(context, "Botón básico presionado", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Botón básico")
        }

        // --- 2. Botón con color personalizado y esquinas redondeadas ---
        Button(
            onClick = {
                Toast.makeText(context, "Botón color verde presionado", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.size(width = 220.dp, height = 50.dp),
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4CAF50),
                contentColor = Color.White
            ),
            shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
        ) {
            Text(text = "Verde personalizado")
        }

        // --- 3. Botón con icono a la izquierda ---
        Button(
            onClick = {
                Toast.makeText(context, "Botón con ícono", Toast.LENGTH_SHORT).show()
            }
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = "Ícono de flecha"
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Con icono")
        }

        // --- 4. Botón Outlined ---
        OutlinedButton(onClick = {
            Toast.makeText(context, "Outlined presionado", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Outlined Button")
        }

        // --- 5. TextButton (sin fondo) ---
        androidx.compose.material3.TextButton(onClick = {
            Toast.makeText(context, "TextButton presionado", Toast.LENGTH_SHORT).show()
        }) {
            Text(
                text = "TextButton",
                textDecoration = TextDecoration.Underline
            )
        }

        // --- 6. IconButton ---
        IconButton(onClick = {
            Toast.makeText(context, "IconButton presionado", Toast.LENGTH_SHORT).show()
        }) {
            Icon(
                imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = "Icono flecha atrás",
                tint = Color.Black
            )
        }

        // --- 7. Botón con estado dinámico ---
        Button(
            onClick = { isClicked = !isClicked },
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = if (isClicked) Color(0xFFE57373) else Color(0xFF81C784)
            )
        ) {
            Text(if (isClicked) "¡Presionado!" else "Presióname")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun CustomScreen(
    title: String,
    content: @Composable () -> Unit,
    onTap: (() -> Unit)? = null,
    backgroundColor: Color = Color(0xFFA3485A) // Se puede cambiar por cada custom screen
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = title) },
                navigationIcon = {
                    if (onTap != null) {
                        IconButton(
                            onClick = onTap
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBackIosNew,
                                contentDescription = "Back"
                            )
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(paddingValues)
        ) {
            content()
        }
    }
}