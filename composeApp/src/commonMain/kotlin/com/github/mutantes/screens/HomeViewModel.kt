package com.github.mutantes.screens

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.github.mutantes.model.ToDo
import com.github.mutantes.model.ToDoDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(toDoDao: ToDoDao? = null) : ViewModel() {

    private val _screenState : MutableStateFlow<List<ToDo>> = MutableStateFlow(listOf())
    val screenState = _screenState.asStateFlow()
    lateinit var toDoCache:Flow<List<ToDo>>

    init {
        toDoDao?.let {
            toDoCache = toDoDao.getAll()
        }
    }

    fun addToDo(toDo: ToDo){
        val updatedList = _screenState.value.toMutableList()
        updatedList.add(toDo)
        _screenState.value = updatedList
    }
    fun removeToDo(toDo: ToDo){
        val updatedList = _screenState.value.toMutableList()
        updatedList.remove(toDo)
        _screenState.value = updatedList
    }
    fun updateToDo(index : Int){
        val updatedList = _screenState.value.toMutableList()
        val currentToDo = updatedList[index]
        val updatedToDo = currentToDo.copy(isChecked = !currentToDo.isChecked)
        updatedList[index] = updatedToDo
        _screenState.value = updatedList
    }
}