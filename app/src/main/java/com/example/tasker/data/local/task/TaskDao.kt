package com.example.tasker.data.local.task

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.tasker.core.Constants.TASK_TABLE
import com.example.tasker.data.local.task.model.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("select * from TaskEntity")
    fun getAllTasks(): Flow<List<TaskEntity>>

    @Query("select * from TaskEntity where categoryName = :categoryName")
    fun getTasksFromCategory(categoryName : String): Flow<List<TaskEntity>>

    @Upsert
    suspend fun upsertTask(task: TaskEntity)

    @Query("delete from taskentity where categoryName = :categoryName")
    suspend fun deleteAllTasksFromCategory(categoryName: String)

    @Delete
    suspend fun deleteTask(task: TaskEntity)

}