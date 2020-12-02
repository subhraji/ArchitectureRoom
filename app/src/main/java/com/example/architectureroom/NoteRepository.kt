package com.example.architectureroom

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteRepository(context: Context) {
    private val db = NoteDatabase.getNoteDatabase(context)

    fun insert(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            db.noteDao.insert(note)
        }
    }

    fun update(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            db.noteDao.update(note)
        }

    }

    fun delete(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            db.noteDao.delete(note)

        }
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return db.noteDao.getAllNotes()
    }


}