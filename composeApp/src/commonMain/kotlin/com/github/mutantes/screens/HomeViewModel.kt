package com.github.mutantes.screens

import androidx.lifecycle.ViewModel
import com.github.mutantes.model.ToDo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {

    private val _screenState : MutableStateFlow<List<ToDo>> = MutableStateFlow(listOf())
    val screenState = _screenState.asStateFlow()

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