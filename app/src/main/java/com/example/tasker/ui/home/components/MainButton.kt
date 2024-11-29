package com.example.tasker.ui.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.example.tasker.data.local.categorias.model.CategoryEntity

@Composable
fun MainButton(
    modifier : Modifier = Modifier,
    textButton : String,
    colorSelected : String,
    enabled : Boolean = true,
    onClick : () -> Unit
) {

    Button(
        onClick = {
                  onClick()
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF7FFFD)
        ),
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(1.dp, if (colorSelected.isEmpty()) Color.Black else Color("#$colorSelected".toColorInt())),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp
        ),
        enabled = enabled
    ) {

        Text(
            text = textButton,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

    }

}