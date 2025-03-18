package com.github.mutantes.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo")
    fun getAll(): Flow<List<ToDo>>

    @Upsert
    fun upsert(toDo: ToDo)

    @Delete
    fun delete (toDo: ToDo)
}