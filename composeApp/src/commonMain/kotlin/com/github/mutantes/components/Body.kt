package com.github.mutantes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.mutantes.model.ToDo
import com.github.mutantes.model.ToDoDao
import com.github.mutantes.screens.HomeViewModel
import com.github.mutantes.style.Colors

@Composable
fun Body(toDoDao: ToDoDao? = null) {
    val homeViewModel = remember { HomeViewModel() }
    val state = homeViewModel.screenState.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.gray600)
            .height(200.dp)
    ) {
        ToDoInput(onAdd = { homeViewModel.addToDo(ToDo(isChecked = false, description = it)) })
        Counter(created = state.size, completed = state.filter { it.isChecked }.size)
        Spacer(modifier = Modifier.height(20.dp))
        ToDoList(
            state.toMutableList(), onChecked = { homeViewModel.updateToDo(it) },
            onDelete = { homeViewModel.removeToDo(state.get(it)) })
    }
}