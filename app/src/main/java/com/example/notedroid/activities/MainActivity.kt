package com.example.notedroid.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.notedroid.databinding.ActivityMainBinding
import com.example.notedroid.db.NoteDatabase
import com.example.notedroid.repository.NoteRepository
import com.example.notedroid.viewModel.NoteActivityViewModel
import com.example.notedroid.viewModel.NoteActivityViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var noteActivityViewModel: NoteActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding= ActivityMainBinding.inflate(layoutInflater)

        try {
            setContentView(binding.root)
            val noteRepository= NoteRepository(NoteDatabase(this))
            val noteActivityViewModelFactory= NoteActivityViewModelFactory(noteRepository)
            noteActivityViewModel= ViewModelProvider(this,
            noteActivityViewModelFactory)[NoteActivityViewModel::class.java]
        }catch (e: Exception)
        {
            Log.d("Tag","Error")
        }

    }
}