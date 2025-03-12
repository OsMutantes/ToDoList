package com.github.mutantes.style

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun ThemeApp(content: @Composable () -> Unit) {
    val typography = AppTypography()
    MaterialTheme (
        typography = typography,
        content= content
    )
}