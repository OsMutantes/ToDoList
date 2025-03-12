package com.github.mutantes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.mutantes.style.Colors

@Composable
fun Body(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Colors.gray600)
        .height(200.dp)) {
        ToDoInput(onAdd = { println(it) })
    }
}