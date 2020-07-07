package com.nicootech.mynotes.ui

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation

import com.nicootech.mynotes.R
import com.nicootech.mynotes.dp.Note

import com.nicootech.mynotes.dp.NoteDatabase
import kotlinx.android.synthetic.main.fragment_add_new_note.*
import kotlinx.android.synthetic.main.fragment_note.*
import kotlinx.coroutines.launch

class AddNewNoteFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_new_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button_save.setOnClickListener{view->
            val noteTitle = edit_text_title.text.toString().trim()
            val noteBody = edit_text_note.text.toString().trim()

            if(noteTitle.isEmpty()){
                edit_text_title.error = "title required"
                edit_text_title.requestFocus()
                return@setOnClickListener
            }

            if(noteTitle.isEmpty()){
                edit_text_note.error = "note required"
                edit_text_note.requestFocus()
                return@setOnClickListener
            }
            launch {
                val note = Note(noteTitle,noteBody)
                context?.let{
                    NoteDatabase(it).getNoteDao().addNote(note)
                    Toast.makeText(activity,"Note Saved", Toast.LENGTH_SHORT).show()

                    val action = AddNewNoteFragmentDirections.actionAddNewNoteFragmentToNoteFragment()
                    Navigation.findNavController(view).navigate(action)
                }
            }

        }
    }



}
