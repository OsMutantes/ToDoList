package com.github.mutantes.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.github.mutantes.model.ToDoDatabase

fun getToDoDatabase(context: Context): ToDoDatabase {
    val dbFile = context.getDatabasePath("todo.db")
    return Room.databaseBuilder<ToDoDatabase>(
        context = context,
        name = dbFile.absolutePath
    ).setDriver(BundledSQLiteDriver()).build()
}