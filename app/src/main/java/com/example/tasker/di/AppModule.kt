package com.example.tasker.di

import android.content.Context
import androidx.room.Room
import com.example.tasker.core.Constants.CATEGORY_TABLE
import com.example.tasker.core.Constants.TASK_TABLE
import com.example.tasker.data.local.categorias.CategoryDao
import com.example.tasker.data.local.categorias.CategoryDatabase
import com.example.tasker.data.local.task.TaskDao
import com.example.tasker.data.local.task.TasksDatabase
import com.example.tasker.domain.TaskerRepository
import com.example.tasker.domain.TaskerRepositoryImplement
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCategoryDao(
        @ApplicationContext context: Context
    ) : CategoryDao {

        return Room.databaseBuilder(
            context,
            CategoryDatabase::class.java,
            "category_table"
        ).fallbackToDestructiveMigration().build().categoryDao()

    }

    @Provides
    @Singleton
    fun provideTasksDao(
        @ApplicationContext context: Context
    ) : TaskDao {

        return Room.databaseBuilder(
            context,
            TasksDatabase::class.java,
            "task_table"
        ).fallbackToDestructiveMigration().build().tasksDao()

    }

    @Provides
    @Singleton
    fun provideCategoryRepository(
        categoryDao: CategoryDao,
        taskDao: TaskDao
    ) : TaskerRepository {

        return TaskerRepositoryImplement(
            categoryDao = categoryDao,
            tasksDao = taskDao
        )

    }

}