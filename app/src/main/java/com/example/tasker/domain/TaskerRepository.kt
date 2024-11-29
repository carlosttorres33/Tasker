package com.example.tasker.domain

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.tasker.core.Constants
import com.example.tasker.data.local.categorias.model.CategoryEntity
import com.example.tasker.data.local.task.model.TaskEntity
import kotlinx.coroutines.flow.Flow

interface TaskerRepository {

    //region Categories

    fun getAllCategories() : Flow<List<CategoryEntity>>

    fun getSingleCategory(name: String) : Flow<CategoryEntity>

    suspend fun insertNewCategory(category : CategoryEntity)

    suspend fun deleteCategory(category: CategoryEntity)

    //endregion

    //region Tasks

    fun getAllTasks(): Flow<List<TaskEntity>>

    fun getTasksFromCategory(category : String): Flow<List<TaskEntity>>

    suspend fun upsertTask(task: TaskEntity)

    suspend fun deleteTask(task: TaskEntity)

    suspend fun deleteAllTasksFromCategory(categoryName: String)

    //endregion

}