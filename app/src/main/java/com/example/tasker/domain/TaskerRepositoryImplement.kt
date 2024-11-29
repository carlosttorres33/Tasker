package com.example.tasker.domain

import com.example.tasker.data.local.categorias.CategoryDao
import com.example.tasker.data.local.categorias.model.CategoryEntity
import com.example.tasker.data.local.task.TaskDao
import com.example.tasker.data.local.task.model.TaskEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskerRepositoryImplement @Inject constructor(
    private val categoryDao: CategoryDao,
    private val tasksDao: TaskDao
) : TaskerRepository {

    //region Categories

    override fun getAllCategories(): Flow<List<CategoryEntity>> {
        return  categoryDao.getAllCategories()
    }

    override fun getSingleCategory(name: String): Flow<CategoryEntity> {
        return categoryDao.getSingleCategory(name)
    }

    override suspend fun insertNewCategory(category: CategoryEntity) {
        return categoryDao.insertNewCategory(category)
    }

    override suspend fun deleteCategory(category: CategoryEntity) {
        return categoryDao.deleteCategory(category)
    }

    //endregion

    //region Tasks

    override fun getAllTasks(): Flow<List<TaskEntity>> {
        return tasksDao.getAllTasks()
    }

    override fun getTasksFromCategory(category: String): Flow<List<TaskEntity>> {
        return  tasksDao.getTasksFromCategory(category)
    }

    override suspend fun upsertTask(task: TaskEntity) {
        return tasksDao.upsertTask(task)
    }

    override suspend fun deleteTask(task: TaskEntity) {
        return tasksDao.deleteTask(task)
    }

    override suspend fun deleteAllTasksFromCategory(categoryName: String) {
        return tasksDao.deleteAllTasksFromCategory(categoryName)
    }

    //endregion

}