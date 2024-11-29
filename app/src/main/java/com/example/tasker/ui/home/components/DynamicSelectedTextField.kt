package com.example.tasker.ui.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.tasker.data.local.categorias.model.CategoryEntity
import com.example.tasker.ui.home.components.categories.CategoryListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDropdown(
    selectedValue: String,
    options: List<CategoryEntity>,
    label: String,
    onValueChange: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {

    var expanded by remember {
        mutableStateOf(false)
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {

        OutlinedTextField(
            readOnly = true,
            value = selectedValue,
            onValueChange = {},
            placeholder = {
                Text(text = label)
            },
            label = {
                Text(text = label)
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {

            if (options.isNotEmpty()) {

                options.forEach { category ->
                    DropdownMenuItem(
                        text = {
                            CategoryListItem(
                                category = category,
                                enableDelete = false
                            ) {}
                        },
                        onClick = {
                            expanded = false
                            onValueChange(category.categoryName, category.color)
                        }
                    )
                }

            }else{
                DropdownMenuItem(
                    text = { Text(text = "Add some Categories from main screen") },
                    onClick = { expanded = false })
            }

        }

    }

}