package com.example.architectureroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val noteViewModel:NoteViewModel by viewModel()

    private lateinit var title :String
    private lateinit var description : String
    private lateinit var priority : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycleview:RecyclerView = findViewById(R.id.notes_recycler)
        recycleview.layoutManager = LinearLayoutManager(this)
        recycleview.hasFixedSize()

        noteViewModel.getAllNotes().observe(this, Observer {listOfNotes->
            if (listOfNotes.isNotEmpty()){
                val adapter  = NoteAdapter(listOfNotes.toMutableList())
                recycleview.adapter = adapter
            }
        })

        insert_btn.setOnClickListener {
            title = title_edit.text.toString().trim()
            description = description_edit.text.toString().trim()
            priority = priority_edit.text.toString().trim()

            noteViewModel.insert(Note(title,description,priority))
        }
    }
}
