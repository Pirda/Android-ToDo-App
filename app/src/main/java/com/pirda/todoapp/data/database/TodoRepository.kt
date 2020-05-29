package com.pirda.todoapp.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.pirda.todoapp.data.database.TodoDao
import com.pirda.todoapp.data.database.TodoDatabase
import com.pirda.todoapp.data.database.TodoRecord
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class TodoRepository(application: Application) {
    private val todoDao: TodoDao
    private val allTodos: LiveData<List<TodoRecord>>

    init {
        val database = TodoDatabase.getInstance(application.applicationContext)
        todoDao = database!!.todoDao()
        allTodos = todoDao.getAllTodolist()
    }

    fun saveTodoItems(todoItems: List<TodoRecord>) = runBlocking {
        this.launch(Dispatchers.IO) {
            todoDao.saveTodoItems(todoItems)
        }
    }

    fun saveTodo(todo: TodoRecord)= runBlocking {
        this.launch(Dispatchers.IO) {
            todoDao.saveTodo(todo)
        }
    }

    fun updateTodo(todo: TodoRecord) = runBlocking {
        this.launch(Dispatchers.IO) {
            todoDao.updateTodo(todo)
        }
    }

    fun deleteTodo(todo: TodoRecord)  {
        runBlocking{
            this.launch(Dispatchers.IO) {
                todoDao.deleteTodo(todo)
            }
        }
    }


    fun getAllTodoList(): LiveData<List<TodoRecord>> {
        return allTodos
    }

}