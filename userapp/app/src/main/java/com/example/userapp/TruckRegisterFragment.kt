package com.example.userapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.navigation.Navigation

import com.example.userapp.api.RetrofitClient
import com.example.userapp.api.TruckService
import com.example.userapp.models.total_products
import kotlinx.android.synthetic.main.fragment_truck_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TruckRegisterFragment : Fragment() {

lateinit var optionText:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_truck_register, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val options= arrayOf("Type 1 ","Type 2","Type 3","Type 4")
        spinnerBodyType.adapter= activity?.applicationContext?.let { ArrayAdapter<String>(it,android.R.layout.simple_list_item_1,options) }
        spinnerBodyType.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                optionText=options.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                optionText=""
            }


        }


        buttonRegister.setOnClickListener {

            val height = editTextHeight .text.toString().trim()
            val length = editTextLength .text.toString().trim()
            val tonnage = editTextTonnage.text.toString().trim()
            val truckRegNum = editTextTruckRegNum.text.toString().trim()
            val bodyType=optionText



            if (height.isEmpty()) {
                editTextHeight.error = "Height required"
                editTextHeight.requestFocus()
                return@setOnClickListener
            }


            if (length .isEmpty()) {
                editTextLength .error = "length required"
                editTextLength .requestFocus()
                return@setOnClickListener
            }

            if (tonnage.isEmpty()) {
                editTextTonnage.error = "tonnage required"
                editTextTonnage.requestFocus()
                return@setOnClickListener
            }

            if (truckRegNum.isEmpty()) {
                editTextTruckRegNum.error = "truckregNum required"
                editTextTruckRegNum.requestFocus()
                return@setOnClickListener
            }


            if (bodyType.isEmpty()) {
                editTextHeight.error = "BodyType required"
                editTextHeight.requestFocus()
                return@setOnClickListener
            }

            RetrofitClient.instance.postProduct(height,length, tonnage, truckRegNum,bodyType)
                    .enqueue(object : Callback<total_products> {
                        override fun onFailure(call: Call<total_products>, t: Throwable) {
                            Log.d("CHEEZYCODE","errror in fetching",t)
                               }

                        override fun onResponse(
                                call: Call<total_products>,
                                response: Response<total_products>
                        ) {
                            val totalProducts=response.body()
                            if(totalProducts!=null)
                            {
                                Log.d("CHEEZYCODE",totalProducts.toString())
                            }
                        }

                    })


            Navigation.findNavController(view)
                    .navigate(R.id.action_truckRegisterFragment_to_titleFragment)
        }
    }

}