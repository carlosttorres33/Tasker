package com.example.tasker.ui.home.components.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.tasker.data.local.task.model.TaskEntity
import com.example.tasker.ui.home.components.CustomProgressBar

@Composable
fun CategoryCard(
    list: List<TaskEntity>
) {

    val max = list.size
    var done: Int = 0
    var cat = ""

    if (list.isNotEmpty()) {

        list.forEach {
            if (it.isChecked) {
                done++
            }
        }

        cat = list[0].categoryName

        Card(
            modifier = Modifier
                .height(110.dp)
                .width(185.dp)
                .padding(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Text(text = cat, fontWeight = FontWeight.Bold)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = "$max Task(s)", fontSize = 15.sp)
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "$done Done", color = Color.Gray, fontSize = 15.sp)
                }

                CustomProgressBar(
                    max = max,
                    done = done,
                    progressColor = Color("#${list[0].categoryColor}".toColorInt())
                )

            }

        }

    }
}
