package com.github.mutantes.screens

import com.github.mutantes.components.Header
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.github.mutantes.components.Body

@Composable
fun Home () {
    Column {
        Header()
        Body()
    }
}