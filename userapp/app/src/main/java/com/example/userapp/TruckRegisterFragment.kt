package com.example.userapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_truck_register, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonSignUp.setOnClickListener {

            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()
            val name = editTextName.text.toString().trim()
            val school = editTextSchool.text.toString().trim()




            if (email.isEmpty()) {
                editTextEmail.error = "Email required"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }


            if (password.isEmpty()) {
                editTextPassword.error = "Password required"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }

            if (name.isEmpty()) {
                editTextName.error = "Name required"
                editTextName.requestFocus()
                return@setOnClickListener
            }

            if (school.isEmpty()) {
                editTextSchool.error = "School required"
                editTextSchool.requestFocus()
                return@setOnClickListener
            }


           RetrofitClient.instance.postProduct(email, name, password, school)
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