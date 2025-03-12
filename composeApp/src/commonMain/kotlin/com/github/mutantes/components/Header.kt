package com.github.mutantes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.mutantes.style.Colors
import org.jetbrains.compose.resources.painterResource
import todoapp.composeapp.generated.resources.Res
import todoapp.composeapp.generated.resources.rocket_logo

@Composable
fun Header(){
    Box(modifier = Modifier
        .background(Colors.gray700)
        .fillMaxWidth()
        .height(173.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .width(137.dp)
                .height(40.dp),
            painter = painterResource(Res.drawable.rocket_logo),
            contentDescription = null
        )
    }
}