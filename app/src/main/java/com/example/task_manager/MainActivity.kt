package com.example.task_manager

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.task_manager.database.NoteDatabase
import com.example.task_manager.repository.NoteRepository
import com.example.task_manager.viewmodel.NoteViewModel
import com.example.task_manager.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var notesViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
    }

    private fun setupViewModel(){
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory = ViewModelFactory(application, noteRepository)
        notesViewModel = ViewModelProvider(this, viewModelProviderFactory)[NoteViewModel::class.java]
    }
}