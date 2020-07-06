package com.nicootech.mynotes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.nicootech.mynotes.R
import kotlinx.android.synthetic.main.fragment_note.*

class NoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button_add.setOnClickListener {
            val action = NoteFragmentDirections.actionNoteFragmentToAddNewNoteFragment()
            Navigation.findNavController(it).navigate(action)
       }
    }

}
