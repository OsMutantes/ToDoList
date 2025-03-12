package com.github.mutantes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.github.mutantes.style.Colors
import org.jetbrains.compose.resources.painterResource
import todoapp.composeapp.generated.resources.Res
import todoapp.composeapp.generated.resources.plus

@Composable
fun ToDoInput(onAdd : (inputText : String)->Unit) {
    val focusRequester = remember { FocusRequester() }
    var value by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }

    Row(modifier = Modifier
        .offset (y = (-26).dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 20.dp)
                .height(52.dp)
                .border(
                    width = 2.dp,
                    color = if (isFocused) Colors.purpleDark else Colors.gray700,
                    shape = RoundedCornerShape(6.dp)
                )
                .clip(shape = RoundedCornerShape(6.dp))
                .background(color = Colors.gray500)
                .focusRequester(focusRequester)
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                }, contentAlignment = Alignment.CenterStart
        ) {
            BasicTextField(
                modifier = Modifier.padding(16.dp),
                value = value,
                onValueChange = { value = it },
                maxLines = 1,
                textStyle = MaterialTheme.typography.body1.copy(color = Colors.gray100),
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = "Adicione uma nova tarefa",
                            style = MaterialTheme.typography.h1,
                            color = Colors.gray300
                        )
                    }
                    innerTextField()
                }, cursorBrush = SolidColor(Colors.gray100)
            )
        }
        Box(modifier = Modifier
            .padding(start = 4.dp, end = 20.dp)
            .size(51.dp)
            .padding(top = 1.dp, bottom = 1.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Colors.blueDark)
            .clickable{
                onAdd(value)
                value = ""
            },
            contentAlignment = Alignment.Center
        ){
            Image(modifier = Modifier
                .size(16.dp)
                , painter = painterResource(Res.drawable.plus), contentDescription = null, colorFilter = ColorFilter.tint(Colors.gray100))
        }
    }
}