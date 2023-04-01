package com.example.notedroid.repository

import com.example.notedroid.db.NoteDatabase
import com.example.notedroid.model.Note

class NoteRepository(private val db: NoteDatabase) {

    fun getNote()= db.getNoteDao().getAllNote()

    fun searchNote(query: String)= db.getNoteDao().searchNotes(query)

    suspend fun addNote(note : Note)= db.getNoteDao().addNote(note)

    suspend fun updateNote(note : Note)= db.getNoteDao().updateNote(note)

    suspend fun deleteNote(note : Note)= db.getNoteDao().deleteNote(note)

}