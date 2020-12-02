package com.example.architectureroom

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class NoteViewModel(private val noteRepository: NoteRepository): ViewModel(){

    fun insert(note: Note){
        noteRepository.insert(note)
    }

    fun update(note: Note){
        noteRepository.update(note)
    }
    fun delete(note: Note){
        noteRepository.delete(note)
    }
    fun getAllNotes(): LiveData<List<Note>>{
        return noteRepository.getAllNotes()
    }
}