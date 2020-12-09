package com.example.userapp

import android.os.Bundle
import android.system.Os.bind
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userapp.activities.MainActivity

import com.example.userapp.adapter.ProductsAdapter
import com.example.userapp.api.RetrofitClient
import com.example.userapp.models.total_products
import kotlinx.android.synthetic.main.fragment_total_trucks.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TotalTrucksFragment : Fragment() {
    lateinit var adapter: ProductsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_total_trucks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        getProducts()

    }


    fun getProducts(){


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
                            adapter= ProductsAdapter(activity!!,totalProducts)
                            Product_List_Recycler_view.adapter=adapter
                            Product_List_Recycler_view.layoutManager= LinearLayoutManager(activity)
                        }
                    }

                })

    }

//    override fun onResume() {
//        super.onResume()
//        adapter.notifyDataSetChanged()
//    }

}