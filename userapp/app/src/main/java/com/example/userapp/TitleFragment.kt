package com.example.userapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.ui.navigateUp
import kotlinx.android.synthetic.main.fragment_title.*

class TitleFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

            return inflater.inflate(R.layout.fragment_title, container, false)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonRegisterTruck.setOnClickListener {
            Navigation.findNavController(view)
                    .navigate(R.id.action_titleFragment_to_truckRegisterFragment)
        }
        buttonViewRegisteredTrucks.setOnClickListener {
            Navigation.findNavController(view)
                    .navigate(R.id.action_titleFragment_to_totalTrucksFragment)
        }
    }

    }
