package com.lenibonje.habari.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lenibonje.habari.R

/**
 * A simple [Fragment] subclass.
 * Use the [SavedFragment] factory method to
 * create an instance of this fragment.
 */
class SavedFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved, container, false)
    }

}