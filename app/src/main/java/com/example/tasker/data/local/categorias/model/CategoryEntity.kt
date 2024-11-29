package com.example.tasker.data.local.categorias.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tasker.core.Constants.CATEGORY_TABLE

@Entity
data class CategoryEntity(
    @PrimaryKey(autoGenerate = false)
    val categoryName : String = "",
    val color : String
)
