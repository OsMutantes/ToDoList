package com.github.mutantes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.mutantes.model.ToDo
import com.github.mutantes.style.Colors

@Composable
fun Body(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Colors.gray600)
        .height(200.dp)) {
        ToDoInput(onAdd = { println(it) })
        Counter(created = 100, completed = 100)
        Spacer(modifier = Modifier.height(20.dp))
        ToDoList(listOf(
            ToDo(isChecked = false, description = "testando a teste"),
            ToDo(isChecked = true, description = "testando a lista"),
            ToDo(isChecked = true, description = "testando a coisa"),
            ToDo(isChecked = false, description = "testando a erick"),
            ToDo(isChecked = true, description = "testando a italo"),
            ToDo(isChecked = false, description = "testando a julio"),
            ToDo(isChecked = false, description = "testando a amit")
        ))
    }
}