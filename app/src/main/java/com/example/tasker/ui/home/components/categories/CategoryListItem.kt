package com.example.tasker.ui.home.components.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.tasker.data.local.categorias.model.CategoryEntity

@Composable
fun CategoryListItem(
    category: CategoryEntity,
    enableDelete: Boolean = true,
    deleteClick: (CategoryEntity) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = category.categoryName,
            modifier = Modifier
                .padding(top = 6.dp),
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .size(20.dp)
                .background(
                    color = Color("#${category.color}".toColorInt()),
                    shape = RoundedCornerShape(10.dp)
                )
        )
        if (enableDelete) {
            IconButton(
                onClick = {
                    deleteClick(category)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Icon",
                    modifier = Modifier.size(20.dp)
                )
            }
        }

    }

    Spacer(
        modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color.Transparent,
                        Color.Gray,
                        Color.Transparent
                    )
                )
            )
            .padding(bottom = 6.dp)
    )

}