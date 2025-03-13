package com.github.mutantes.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class ToDo(
    var isCheckedInitial : Boolean,
    val description : String
){
    var isChecked by mutableStateOf(isCheckedInitial)
}