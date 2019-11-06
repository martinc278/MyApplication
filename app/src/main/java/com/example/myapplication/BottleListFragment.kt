package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BottleListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 */
class BottleListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var listener: BottleListFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview= inflater.inflate(R.layout.fragment_bottle_list, container, false)
        val listBottle = arguments!!.getSerializable("bottles") as ArrayList<Bottle>

        recyclerView = rootview.findViewById<RecyclerView>(R.id.a_rcv_bottles)
        val adapter = BottleAdapter(listBottle, AdapterView.OnItemClickListener { parent, view, position, id ->
            listBottle.removeAt(position)
            recyclerView.adapter?.notifyDataSetChanged()

        })
        recyclerView.adapter = adapter

        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager

        return rootview
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BottleListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement BottleListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface BottleListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun DeleteFromFragment(n: Int)
    }

}
