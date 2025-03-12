package com.github.mutantes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.mutantes.style.Colors

@Composable
fun GrayScaleExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.gray700)
            .padding(16.dp)
    ) {
        Text(
            text = "Cinza 100",
            color = Colors.gray100,
            fontSize = 20.sp
        )
        Text(
            text = "Cinza 200",
            color = Colors.gray200,
            fontSize = 20.sp
        )
        Text(
            text = "Cinza 300",
            color = Colors.gray300,
            fontSize = 20.sp
        )
        Text(
            text = "Cinza 400",
            color = Colors.gray400,
            fontSize = 20.sp
        )
        Text(
            text = "Cinza 500",
            color = Colors.gray500,
            fontSize = 20.sp
        )
        Text(
            text = "Cinza 600",
            color = Colors.gray600,
            fontSize = 20.sp
        )
        Text(
            text = "Cinza 700",
            color = Colors.gray700,
            fontSize = 20.sp,
            modifier = Modifier.background(Colors.gray100)
        )
    }
}