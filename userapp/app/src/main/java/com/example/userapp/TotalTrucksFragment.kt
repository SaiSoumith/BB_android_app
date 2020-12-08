package com.example.userapp

import android.os.Bundle
import android.system.Os.bind
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.userapp.activities.MainActivity
import com.example.userapp.activities.adapter
import kotlinx.android.synthetic.main.fragment_total_trucks.*


class TotalTrucksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_total_trucks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        (activity as MainActivity?)?.getProducts()

    }


    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }

}