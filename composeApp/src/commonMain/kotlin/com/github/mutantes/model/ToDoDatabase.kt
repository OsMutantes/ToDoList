package com.github.mutantes.model

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

@ConstructedBy(ToDoDatabaseConstructor::class)
@Database(entities = [ToDo::class], version = 1)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun toDoDao():ToDoDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object ToDoDatabaseConstructor : RoomDatabaseConstructor<ToDoDatabase> {
    override fun initialize(): ToDoDatabase
}