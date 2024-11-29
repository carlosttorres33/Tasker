package com.example.tasker.ui.home.components.categories

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.core.graphics.toColorInt
import com.example.tasker.data.local.categorias.model.CategoryEntity
import com.example.tasker.ui.home.components.MainButton
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.rememberColorPickerController

@Composable
fun AddCategoriesDialog(
    onDismissRequest: () -> Unit,
    addCategory: (CategoryEntity) -> Unit
) {

    var newCategoryName by remember {
        mutableStateOf("")
    }

    var showAlphaSlider by remember {
        mutableStateOf(false)
    }

    var colorSelected by remember {
        mutableStateOf("FFFFFF")
    }

    val controller = rememberColorPickerController()

    Dialog(
        onDismissRequest = {
            onDismissRequest()
        }
    ) {

        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 8.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {

                TextField(
                    value = newCategoryName,
                    onValueChange = {
                        if (it.length < 30) {
                            newCategoryName = it
                        }
                    },
                    placeholder = {
                        Text(text = "ex. School")
                    },
                    label = {
                        Text(text = "Category Name")

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    maxLines = 1,
                )

                Text(
                    text = "Pick a Color",
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                HsvColorPicker(
                    modifier = Modifier
                        .size(300.dp)
                        .padding(horizontal = 16.dp),
                    controller = controller,
                    onColorChanged = {
                        colorSelected = it.hexCode
                    }
                )


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 36.dp)
                        .height(20.dp)
                        .background(
                            color = Color("#$colorSelected".toColorInt()),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .clickable {
                            showAlphaSlider = !showAlphaSlider
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = colorSelected)
                }

                MainButton(
                    textButton = "Add Category",
                    colorSelected = colorSelected
                ) {
                    if (newCategoryName.isNotEmpty() || colorSelected == "FFFFFF") {
                        addCategory(
                            CategoryEntity(
                                categoryName = newCategoryName,
                                color = colorSelected
                            )
                        )
                        onDismissRequest()
                    }
                }
            }
        }
    }
}