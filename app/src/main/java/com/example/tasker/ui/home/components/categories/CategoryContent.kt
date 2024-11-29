package com.example.tasker.ui.home.components.categories

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasker.core.Resource
import com.example.tasker.data.local.categorias.model.CategoryEntity
import com.example.tasker.data.local.task.model.TaskEntity
import com.example.tasker.domain.TaskerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@Composable
fun CategoryContent(
    onEditCategoryClick: () -> Unit,
    categoriesList: List<CategoryEntity>,
    tasks: List<TaskEntity>,
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = "Categories", fontSize = 20.sp)
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = {
                onEditCategoryClick()
            }
        ) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit Categories")
        }

    }

    if (categoriesList.isEmpty()) {
        Text(
            text = "NO HAY TAREAS/CATEGORIAS AGREGADAS",
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            textAlign = TextAlign.Center,
            color = Color.Gray
        )
    } else {

        LazyRow {

            items(categoriesList) { item ->

                CategoryCard(list = tasks.filter { it.categoryName == item.categoryName })

            }

        }

    }

}