package com.github.mutantes

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {

    val state = rememberWindowState(
        height = 1280.dp,
        width = 720.dp
    )
    Window(
        onCloseRequest = ::exitApplication,
        title = "ToDoApp",
        state = state
    ) {
        App()
    }
}