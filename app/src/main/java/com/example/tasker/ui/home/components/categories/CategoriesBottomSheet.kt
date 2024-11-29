package com.example.tasker.ui.home.components.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.tasker.data.local.categorias.model.CategoryEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesBottomSheet(
    categoriesList: List<CategoryEntity>,
    onDismissRequest: () -> Unit,
    addCategoryClick: () -> Unit,
    onDeleteCategory: (CategoryEntity) -> Unit
) {

    ModalBottomSheet(
        onDismissRequest = {
            onDismissRequest()
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 24.dp)
        ) {

            if (categoriesList.isNotEmpty()) {
                LazyColumn {
                    items(categoriesList) { singleCategory ->
                        CategoryListItem(
                            category = singleCategory
                        ) { categoryToDelete ->
                            onDeleteCategory(categoryToDelete)
                        }
                    }
                }
            } else {
                Text(
                    text = "Sin Categorias",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Row(Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(imageVector = Icons.Default.Warning, contentDescription = "")
                    Spacer(modifier = Modifier.weight(1f))
                }
            }

            Button(
                onClick = {
                    addCategoryClick()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Text(text = "Agregar Nueva Categoria")
            }

        }

    }

}