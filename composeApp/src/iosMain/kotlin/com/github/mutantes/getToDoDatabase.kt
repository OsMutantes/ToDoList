package com.github.mutantes

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.github.mutantes.model.ToDoDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

fun getToDoDatabase() : ToDoDatabase{
    val dbFile = "${documentDirectory()}/todo.db"

    return Room.databaseBuilder<ToDoDatabase>(
        name = dbFile
    ).setDriver(BundledSQLiteDriver()).build()
}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory() : String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}