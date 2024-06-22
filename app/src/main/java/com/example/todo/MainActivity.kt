package com.example.todo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    private lateinit var toDoAdapter: ToDoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val rvTodoItems = findViewById<RecyclerView>(R.id.rvTodoItems)
        toDoAdapter = ToDoAdapter(mutableListOf())

        rvTodoItems.adapter = toDoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        val btnAddToDo = findViewById<Button>(R.id.btnAddTodo)
        btnAddToDo.setOnClickListener {
            val etTodoTitle = findViewById<EditText>(R.id.etTodoTitle)
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle)
                toDoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }
        val btnDeleteDoneTodos = findViewById<Button>(R.id.btnDeleteDoneTodos)
        btnDeleteDoneTodos.setOnClickListener {
            toDoAdapter.deleteDoneTodos()
        }
    }
}