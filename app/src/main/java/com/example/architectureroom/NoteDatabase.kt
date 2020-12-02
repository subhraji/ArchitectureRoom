package com.example.architectureroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteStatement

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase:RoomDatabase(){
    abstract val noteDao: NoteDao

    companion object{
        private var INSTANCE: NoteDatabase? = null

        fun getNoteDatabase(context: Context): NoteDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java, "note_db"
                )
                    .fallbackToDestructiveMigration()
                    //.allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as NoteDatabase
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}