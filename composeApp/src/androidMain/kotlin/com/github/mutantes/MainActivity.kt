package com.github.mutantes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.github.mutantes.database.getToDoDatabase
import com.github.mutantes.model.ToDo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val dao = getToDoDatabase(context = applicationContext).toDoDao()
        setContent {
            App(dao)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}