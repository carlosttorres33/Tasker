package com.example.tasker.ui.home.components.tasks

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tasker.data.local.categorias.model.CategoryEntity
import com.example.tasker.data.local.task.model.TaskEntity
import com.example.tasker.ui.home.components.CategoryDropdown
import com.example.tasker.ui.home.components.MainButton
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskBottomSheet(
    categoriesList: List<CategoryEntity>,
    onDismissRequest: () -> Unit,
    addTaskClick: (TaskEntity) -> Unit
) {

    var categorySelected by remember {
        mutableStateOf("")
    }
    var categoryColorSelected by remember {
        mutableStateOf("")
    }

    var taskTitle by remember {
        mutableStateOf("")
    }

    ModalBottomSheet(
        onDismissRequest = {
            onDismissRequest()
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            OutlinedTextField(
                value = taskTitle,
                onValueChange = {
                    taskTitle = it
                },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Task Title")
                },
                placeholder = {
                    Text(text = "ex. Go To mall")
                }
            )

            CategoryDropdown(
                selectedValue = categorySelected,
                options = categoriesList,
                label = "Pick Category",
                onValueChange = { categoryName, categoryColor ->
                    categorySelected = categoryName
                    categoryColorSelected = categoryColor
                }
            )

            MainButton(
                textButton = "Add Task",
                colorSelected = categoryColorSelected,
                enabled = if (categorySelected.isNotEmpty() && taskTitle.isNotEmpty()) true else false
            ) {
                addTaskClick(
                    TaskEntity(
                        taskTitle = taskTitle,
                        categoryName = categorySelected,
                        categoryColor = categoryColorSelected,
                        isChecked = false
                    )

                )
                Log.d("Color", categoryColorSelected)
                onDismissRequest()
            }

        }

    }

}