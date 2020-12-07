package com.example.userapp.activities

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import androidx.databinding.DataBindingUtil
import com.example.userapp.R
import com.example.userapp.api.RetrofitClient
import com.example.userapp.models.DefaultResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}