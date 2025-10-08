package com.losmoviles.tasksapp.feature.createtask

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.losmoviles.tasksapp.model.DayUi

@Composable
fun DayChipUi(day: DayUi) {
    val bg = if (day.selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
    val fg = if (day.selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
    Surface(
        color = bg,
        shape = RoundedCornerShape(16.dp),
        tonalElevation = if (day.selected) 4.dp else 1.dp
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("${day.number}", color = fg, fontWeight = FontWeight.SemiBold)
            Text(day.short, color = fg, fontSize = 12.sp)
        }
    }
}
