package com.example.userapp.activities

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.databinding.DataBindingUtil
import com.example.userapp.R
import com.example.userapp.adapter.ProductsAdapter
import com.example.userapp.api.RetrofitClient
import com.example.userapp.models.total_products
import kotlinx.android.synthetic.main.fragment_total_trucks.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }



}