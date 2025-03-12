package com.github.mutantes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.mutantes.style.ThemeApp

@Composable
fun MyNewThemeScreen() {
    ThemeApp {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Título Grande",
                style = MaterialTheme.typography.h1
            )
            Text(
                text = "Texto Normal",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "Pequeno Rótulo",
                style = MaterialTheme.typography.body2
            )
        }
    }
}