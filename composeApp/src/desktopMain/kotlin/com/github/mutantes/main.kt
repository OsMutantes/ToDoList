package com.github.mutantes

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.github.mutantes.database.getToDoDatabase
import org.jetbrains.compose.resources.painterResource
import todoapp.composeapp.generated.resources.Res
import todoapp.composeapp.generated.resources.icon

fun main() = application {

    val state = rememberWindowState(
        height = 800.dp,
        width = 600.dp
    )

    val dao = getToDoDatabase().toDoDao()

    Window(
        onCloseRequest = ::exitApplication,
        title = "ToDoApp",
        state = state,
        resizable = false,
        icon = painterResource(Res.drawable.icon)
    ) {
        App(dao)
    }
}