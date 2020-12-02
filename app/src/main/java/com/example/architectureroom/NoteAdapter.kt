package com.example.architectureroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.notes_item.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class NoteAdapter(private val noteList: MutableList<Note>):RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        return NoteViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.notes_item, parent, false))
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = noteList[position]
        holder.itemView.apply {

            idView.text = note.id.toString()
            titleView.text = note.title
            descriptionView.text = note.description
            delete_note.setOnClickListener {
               val db = NoteDatabase.getNoteDatabase(context)

                CoroutineScope(Dispatchers.IO).launch {
                    db.noteDao.delete(note)
                }
                noteList.removeAt(position)
                notifyItemRemoved(position)
            }
        }

    }


    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}