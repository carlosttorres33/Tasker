package com.example.tasker.ui.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tasker.core.Resource
import com.example.tasker.presentation.home.HomeViewModel
import com.example.tasker.ui.home.components.categories.AddCategoriesDialog
import com.example.tasker.ui.home.components.categories.CategoriesBottomSheet
import com.example.tasker.ui.home.components.categories.CategoryContent
import com.example.tasker.ui.home.components.tasks.AddTaskBottomSheet
import com.example.tasker.ui.home.components.tasks.TasksContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {

    val categoriesList by viewModel.categories.collectAsState(initial = emptyList())
    val tasksList by viewModel.tasks.collectAsState(initial = emptyList())

    var showAddCategoryDialog by remember {
        mutableStateOf(false)
    }

    var showCategoriesBottomSheet by remember {
        mutableStateOf(false)
    }

    var showAddTaskBottomSheet by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Tasker", textAlign = TextAlign.Center)
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showAddTaskBottomSheet = true }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        }
    ) { paddingValues ->

        Box(modifier = Modifier.fillMaxSize()) {

            if (showCategoriesBottomSheet) {

                CategoriesBottomSheet(
                    categoriesList = categoriesList,
                    onDismissRequest = {
                        showCategoriesBottomSheet = !showCategoriesBottomSheet
                    },
                    addCategoryClick = {
                        showAddCategoryDialog = !showAddCategoryDialog
                    },
                    onDeleteCategory = { categoryToDelete ->
                        viewModel.deleteCategory(categoryToDelete)
                    }
                )

            }

            if (showAddCategoryDialog) {

                AddCategoriesDialog(onDismissRequest = {
                    showAddCategoryDialog = !showAddCategoryDialog
                }) {
                    viewModel.addCategory(it)
                }

            }

            if (showAddTaskBottomSheet) {
                AddTaskBottomSheet(
                    categoriesList = categoriesList,
                    onDismissRequest = {
                        showAddTaskBottomSheet = false
                    },
                    addTaskClick = { taskToAdd ->
                        viewModel.upsertTask(taskToAdd)
                    }
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                CategoryContent(
                    onEditCategoryClick = {
                        showCategoriesBottomSheet = !showCategoriesBottomSheet
                    },
                    categoriesList = categoriesList,
                    tasks = tasksList,
                )

                TasksContent(
                    tasksList = tasksList,
                    updateTask = {
                        viewModel.upsertTask(it)
                    }
                )

            }

        }

    }

}
