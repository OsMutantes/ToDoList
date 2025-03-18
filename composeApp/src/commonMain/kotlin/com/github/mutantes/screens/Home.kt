package com.github.mutantes.screens

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import com.github.mutantes.components.Body
import com.github.mutantes.components.Header
import com.github.mutantes.model.ToDoDao

@Composable
fun Home(toDoDao: ToDoDao? = null) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier.pointerInput(Unit) {
            detectTapGestures(onTap = {
                focusManager.clearFocus(true)
            })
        }
    ) {
        Header()
        Body(toDoDao)
    }
}