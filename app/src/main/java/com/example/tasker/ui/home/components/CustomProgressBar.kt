package com.example.tasker.ui.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun CustomProgressBar(
    modifier: Modifier = Modifier,
    max: Int,
    done: Int,
    progressColor: Color,
    clipShape: Shape = RoundedCornerShape(16.dp)
) {
    val progress = ((done * 100) / max) * 0.01
    Box(
        modifier = modifier
            .clip(clipShape)
            .height(9.dp)
            .fillMaxWidth()
            .background(color = Color.Blue)
    ) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxSize(),
            color = progressColor,
            progress = progress.toFloat(),
        )
    }
}