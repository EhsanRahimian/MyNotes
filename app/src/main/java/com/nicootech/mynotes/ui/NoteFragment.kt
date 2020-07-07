package com.nicootech.mynotes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.nicootech.mynotes.R
import com.nicootech.mynotes.dp.NoteDatabase
import kotlinx.android.synthetic.main.fragment_note.*
import kotlinx.coroutines.launch

class NoteFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

        //fetching notes
        launch{
            context?.let{
                val notes = NoteDatabase(it).getNoteDao().getAllNotes()
                recycler_view.adapter = NoteAdapter(notes)

            }

        }

        button_add.setOnClickListener {
            val action = NoteFragmentDirections.actionNoteFragmentToAddNewNoteFragment()
            Navigation.findNavController(it).navigate(action)
       }
    }

}
