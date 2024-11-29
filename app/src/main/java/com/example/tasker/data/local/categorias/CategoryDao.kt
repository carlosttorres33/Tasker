package com.example.tasker.data.local.categorias

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tasker.core.Constants.CATEGORY_TABLE
import com.example.tasker.data.local.categorias.model.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("SELECT * FROM CategoryEntity")
    fun getAllCategories() : Flow<List<CategoryEntity>>

    @Query("SELECT * FROM CategoryEntity where categoryName = :name")
    fun getSingleCategory(name: String) : Flow<CategoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewCategory(category : CategoryEntity)

    @Delete
    suspend fun deleteCategory(category: CategoryEntity)

}