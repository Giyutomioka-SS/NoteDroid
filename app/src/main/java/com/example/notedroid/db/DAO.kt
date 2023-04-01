package com.example.notedroid.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notedroid.model.Note


@Dao
interface DAO {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Query("SELECT * FROM Note ORDER BY id DESC")
    fun getAllNote(): LiveData<List<Note>>

    @Query("SELECT * FROM Note WHERE title LIKE :query OR content LIKE :query OR date LIKE :query ORDER BY id DESC")
    fun searchNotes(query: String): LiveData<List<Note>>

    @Delete
    suspend fun deleteNote(note: Note)
}