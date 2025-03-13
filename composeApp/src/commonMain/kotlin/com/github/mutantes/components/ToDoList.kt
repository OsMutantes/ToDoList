package com.github.mutantes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.github.mutantes.model.ToDo
import com.github.mutantes.style.Colors
import org.jetbrains.compose.resources.painterResource
import todoapp.composeapp.generated.resources.Res
import todoapp.composeapp.generated.resources.check_false
import todoapp.composeapp.generated.resources.check_true
import todoapp.composeapp.generated.resources.clipboard

@Composable
fun ToDoList(list: List<ToDo>) {
    if (list.isEmpty()) {
        EmptyList()
    } else {
        list.forEach {
            ToDoCard(it)
        }
    }
}

@Composable
fun ToDoCard(toDo: ToDo) {
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
                .padding(start = (15.25).dp, end = 11.dp)
                .size((17.45).dp),
            painter = painterResource(if (toDo.isChecked) Res.drawable.check_true else Res.drawable.check_false),
            contentDescription = null
        )
        Text(
            toDo.description,
            style = if (toDo.isChecked) MaterialTheme.typography.body2.copy(textDecoration = TextDecoration.LineThrough) else MaterialTheme.typography.body2,
            color = if (toDo.isChecked) Colors.gray300 else Colors.gray100,
        )
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