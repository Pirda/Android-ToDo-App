package com.pirda.todoapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.pirda.todoapp.data.TodoRepository
import com.pirda.todoapp.data.database.TodoRecord
import java.util.*

class TodoViewModel(application: Application): AndroidViewModel(application) {
    private val repository: TodoRepository = TodoRepository(application)
    private val allTodoList: LiveData<List<TodoRecord>> = repository.getAllTodoList()

    fun saveTodo(todo: TodoRecord){
        repository.saveTodo(todo)
    }

    fun updateTodo(todo: TodoRecord){
        repository.updateTodo(todo)
    }

    fun deleteTodo(todo: TodoRecord){
        repository.deleteTodo(todo)
    }

    fun getAllTodoList():LiveData<List<TodoRecord>>{
        return allTodoList
    }

}