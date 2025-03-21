package com.github.mutantes.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.github.mutantes.model.ToDo
import com.github.mutantes.style.Colors
import org.jetbrains.compose.resources.painterResource
import todoapp.composeapp.generated.resources.*

@Composable
fun ToDoList(
    list: MutableList<ToDo>,
    onChecked: (toDo : ToDo) -> Unit,
    onDelete: (toDo : ToDo) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
    ) {
        if (list.isEmpty()) {
            EmptyList()
        } else {
            list.forEach { todo ->
                ToDoCard( todo, onChecked, onDelete)
            }
        }
    }
}

@Composable
fun ToDoCard(
    toDo: ToDo,
    onChecked: (toDo : ToDo) -> Unit,
    onDelete: (toDo : ToDo) -> Unit
) {
    Row(
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(vertical = 4.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Colors.gray500)
            .border(
                color = Colors.gray400,
                shape = RoundedCornerShape(8.dp),
                width = 1.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .clickable { onChecked(toDo) }
                .padding(start = (15.25).dp, end = 11.dp)
                .size((17.45).dp),
            painter = painterResource(if (toDo.isChecked) Res.drawable.check_true else Res.drawable.check_false),
            contentDescription = null
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            var lineCount = 1
            val lineList = mutableListOf<Float>()
            val lineCenters = mutableListOf<Float>()
            Text(
                onTextLayout = { textLayoutResult ->
                    lineCount = textLayoutResult.lineCount
                    lineList.clear()
                    lineCenters.clear()
                    for (i in 0 until lineCount) {
                        lineList.add(textLayoutResult.getLineRight(i))
                        val top = textLayoutResult.getLineTop(i)
                        val bottom = textLayoutResult.getLineBottom(i)
                        lineCenters.add((top + bottom) / 2)
                    }
                },
                modifier = Modifier.drawWithContent {
                    drawContent()
                    val strokeWidth = 2.dp.toPx()
                    for (i in 0 until lineCount) {
                        drawLine(
                            color = if (toDo.isChecked) Colors.gray300 else Color.Transparent,
                            strokeWidth = strokeWidth,
                            start = Offset(0f, lineCenters.getOrElse(i) { 0f }),
                            end = Offset(lineList.getOrElse(i) { size.width }, lineCenters.getOrElse(i) { 0f })
                        )
                    }
                }.weight(1f),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                text = toDo.description,
                style = MaterialTheme.typography.body2,
                color = if (toDo.isChecked) Colors.gray300 else Colors.gray100,
            )
            Image(
                modifier = Modifier
                    .clickable { onDelete(toDo) }
                    .padding(start = (15.25).dp, end = 16.dp)
                    .height(14.dp)
                    .width(12.dp),
                painter = painterResource(Res.drawable.trash),
                contentDescription = null
            )
        }
    }
}

@Composable
fun EmptyList() {
    Column() {
        Box(
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Colors.gray500)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(64.dp),
            painter = painterResource(Res.drawable.clipboard),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Colors.gray400)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Você não tem tarefas cadastradas", color = Colors.gray300, style = MaterialTheme.typography.h1)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Crie tarefas e organize seus itens a fazer",
            color = Colors.gray300,
            style = MaterialTheme.typography.body2
        )
    }
}