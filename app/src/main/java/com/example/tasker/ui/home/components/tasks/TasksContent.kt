package com.example.tasker.ui.home.components.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasker.data.local.task.model.TaskEntity

@Composable
fun TasksContent(
    tasksList: List<TaskEntity>,
    updateTask: (TaskEntity) -> Unit
) {

    Text(text = "Tasks", fontSize = 20.sp, modifier = Modifier.padding(16.dp))

    if (tasksList.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "No hay tareas Aun")
            Spacer(modifier = Modifier.weight(1f))
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp, horizontal = 70.dp)
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")
            }
        }
    } else {

        LazyColumn(
            modifier = Modifier.background(Color.Transparent).fillMaxSize()
        ) {

            items(tasksList) { singleTask ->

                TaskItem(
                    task = singleTask,
                    updateItemChecked = { taskToUpdate ->
                        updateTask(taskToUpdate)
                    }
                )

            }

        }

    }

}