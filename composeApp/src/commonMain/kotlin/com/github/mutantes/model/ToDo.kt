package com.github.mutantes.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDo(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val isChecked : Boolean,
    val description : String
)