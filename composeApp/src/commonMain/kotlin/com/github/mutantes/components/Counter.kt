package com.github.mutantes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.github.mutantes.style.Colors

@Composable
fun Counter(created : Int, completed : Int){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)
        ,horizontalArrangement = Arrangement.SpaceBetween){
        Row() { Text(text = "Criadas", style = MaterialTheme.typography.h1, color = Colors.blueLight )
        ChipNumber("$created")
        }
        Row() { Text(text = "Concluídas", style = MaterialTheme.typography.h1, color = Colors.purple)
            ChipNumber("$completed")
        }
    }
}

@Composable
fun ChipNumber(text : String){
    Box(modifier = Modifier
        .padding(start = 8.dp)
        .clip(CircleShape)
        .background(Colors.gray400)
        .padding(vertical = 1.dp, horizontal = 8.dp)
    ){
        Text(text = text, color = Colors.gray200, style = MaterialTheme.typography.h2)
    }
}