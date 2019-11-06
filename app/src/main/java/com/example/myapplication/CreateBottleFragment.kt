package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CreateBottleFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 */
class CreateBottleFragment : Fragment() {

    private lateinit var rootview: View

    private var listener: CreateBottleFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_create_bottle, container, false)
        rootview.findViewById<Button>(R.id.buttonAddFragment).setOnClickListener {
            stopFragmentAndReturnResult()
        }

        return rootview
    }



    fun stopFragmentAndReturnResult() {
        val newName = rootview.findViewById<EditText>(R.id.bottleName).text.toString()
        val newPrice = rootview.findViewById<EditText>(R.id.bottlePrice).text.toString().toInt()
        val newBottle = Bottle(newName, newPrice)
        listener?.createBottleFromFragment(newBottle)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CreateBottleFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface CreateBottleFragmentInteractionListener {
        fun createBottleFromFragment(bottle: Bottle)
    }

}
