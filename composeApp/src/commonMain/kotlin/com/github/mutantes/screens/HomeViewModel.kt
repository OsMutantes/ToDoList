package com.github.mutantes.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.mutantes.model.ToDo
import com.github.mutantes.model.ToDoDao
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(private val toDoDao: ToDoDao? = null) : ViewModel() {

    private val _screenState: MutableStateFlow<List<ToDo>> = MutableStateFlow(emptyList())
    val screenState: StateFlow<List<ToDo>> = _screenState.asStateFlow()

    init {
        toDoDao?.let { dao ->
            viewModelScope.launch {
                dao.getAll()
                    .onEach { todos -> _screenState.value = todos }
                    .launchIn(this)
            }

            viewModelScope.launch {
                //dao.upsert(ToDo(isChecked = false, description = "Teste"))
            }
        }
    }

    fun addToDo(toDo: ToDo) {
        toDoDao?.let { dao ->
            viewModelScope.launch {
                dao.upsert(toDo)
            }
        }
    }

    fun removeToDo(toDo: ToDo) {
        toDoDao?.let { dao ->
            viewModelScope.launch {
                dao.delete(toDo)
            }
        }
    }

    fun updateToDo(toDo: ToDo) {
        toDoDao?.let { dao ->
            viewModelScope.launch {
                val updatedToDo = toDo.copy(isChecked = !toDo.isChecked)
                dao.upsert(updatedToDo)
            }
        }
    }
}
