package com.example.tasker.ui.home.components.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.example.tasker.data.local.task.model.TaskEntity

@Composable
fun TaskItem(
    task: TaskEntity,
    updateItemChecked: (TaskEntity) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 3.dp)
            .background(color = Color.Transparent),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                colors = CheckboxDefaults.colors(
                    uncheckedColor = Color("#${task.categoryColor}".toColorInt()),
                    checkedColor = Color("#${task.categoryColor}".toColorInt())
                ),
                checked = task.isChecked,
                onCheckedChange = {
                    updateItemChecked(
                        task.copy(
                            isChecked = !task.isChecked
                        )
                    )
                },
            )

            Text(text = task.taskTitle)

        }


    }

}