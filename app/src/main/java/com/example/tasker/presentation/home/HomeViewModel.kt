package com.example.tasker.presentation.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tasker.core.Resource
import com.example.tasker.data.local.categorias.model.CategoryEntity
import com.example.tasker.data.local.task.model.TaskEntity
import com.example.tasker.domain.TaskerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val taskerRepo: TaskerRepository
) : ViewModel() {

    val categories = taskerRepo.getAllCategories()

    val tasks = taskerRepo.getAllTasks()

    fun addCategory(category: CategoryEntity) {

        viewModelScope.launch(Dispatchers.IO) {

            taskerRepo.insertNewCategory(category)

        }

    }

    fun deleteCategory(categoryToDelete: CategoryEntity) {

        viewModelScope.launch(Dispatchers.IO) {
            taskerRepo.deleteAllTasksFromCategory(categoryToDelete.categoryName)
            taskerRepo.deleteCategory(categoryToDelete)
        }

    }

    fun upsertTask(task: TaskEntity) {

        viewModelScope.launch {
            taskerRepo.upsertTask(task)
        }

    }

}