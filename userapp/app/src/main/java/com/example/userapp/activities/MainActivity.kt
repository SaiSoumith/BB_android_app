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
lateinit var adapter: ProductsAdapter
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }



    public fun getProducts(){


        RetrofitClient.instance.getProducts()
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
                            adapter= ProductsAdapter(this@MainActivity,totalProducts)
                            Product_List_Recycler_view.adapter=adapter
                            Product_List_Recycler_view.layoutManager= LinearLayoutManager(this@MainActivity)
                        }
                    }

                })

    }
}