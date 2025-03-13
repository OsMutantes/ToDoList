package com.github.mutantes

import com.github.mutantes.screens.Home
import androidx.compose.runtime.*
import com.github.mutantes.style.ThemeApp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    ThemeApp {
        Home()
    }
}