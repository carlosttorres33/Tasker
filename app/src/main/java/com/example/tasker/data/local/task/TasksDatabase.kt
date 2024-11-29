package com.example.tasker.data.local.task

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tasker.data.local.task.model.TaskEntity

@Database(entities = [TaskEntity::class], version = 3, exportSchema = false)
abstract class TasksDatabase : RoomDatabase() {

    abstract fun tasksDao() : TaskDao

}