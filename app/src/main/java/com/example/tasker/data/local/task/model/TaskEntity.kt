package com.example.tasker.data.local.task.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tasker.core.Constants.TASK_TABLE

@Entity
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Long? = null,
    val taskTitle : String,
    val categoryName : String,
    val categoryColor : String,
    val isChecked : Boolean
)
