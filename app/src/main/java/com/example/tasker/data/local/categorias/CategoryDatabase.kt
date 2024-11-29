package com.example.tasker.data.local.categorias

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tasker.data.local.categorias.model.CategoryEntity

@Database(entities = [CategoryEntity::class], version = 2, exportSchema = false)
abstract class CategoryDatabase : RoomDatabase() {

    abstract fun categoryDao() : CategoryDao

}