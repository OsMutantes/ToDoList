package com.github.mutantes.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.github.mutantes.model.ToDoDatabase
import java.io.File

fun getToDoDatabase(): ToDoDatabase {
    val dbFile = File(System.getProperty("java.io.tmpdir"), "todo.db")
    return Room.databaseBuilder<ToDoDatabase>(
        name = dbFile.absolutePath,
    ).setDriver(BundledSQLiteDriver()).build()
}