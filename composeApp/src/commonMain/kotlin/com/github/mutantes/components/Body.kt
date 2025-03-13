package com.github.mutantes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.mutantes.model.ToDo
import com.github.mutantes.style.Colors

@Composable
fun Body() {
    val list = remember { mutableStateListOf<ToDo>() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.gray600)
            .height(200.dp)
    ) {
        ToDoInput(onAdd = { list.add(ToDo(isCheckedInitial = false, description = it)) })
        Counter(created = list.size, completed = list.filter { it.isChecked }.size)
        Spacer(modifier = Modifier.height(20.dp))
        ToDoList(
            list, onChecked = {
                val todo = list.get(index = it)
                todo.isChecked = !todo.isChecked
                list.removeAt(it)
                list.add(index = it, todo)
            },
            onDelete = { list.removeAt(it) })
    }
}