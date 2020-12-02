package com.example.architectureroom

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
    val title: String,

    val description: String,

    val priority: String

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}