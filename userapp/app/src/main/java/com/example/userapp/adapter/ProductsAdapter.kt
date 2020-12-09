package com.example.userapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.userapp.R
import com.example.userapp.activities.ViewDetailsActivity
import com.example.userapp.models.ProductX


class ProductsAdapter(val context: Context, val products: List<ProductX>) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

    val view=LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
     return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
      val product= this.products[position]
        holder.productId.text= product.id.toString()
        holder.productRegNum.text=product.truckRegNum

        holder.itemView.setOnClickListener {

              val model   =products.get(position)
              var gHeight:String  =model.height
              var gId:String     =model.id.toString()
              var gTonnage:String   =model.tonnage
              var gTruckRegNum:String =model.truckRegNum
              var gBodyType:String =model.bodyType
              var gLength:String=model.length
             val intent=Intent(context, ViewDetailsActivity::class.java)
            intent.putExtra("iHeight", gHeight)
            intent.putExtra("iTonnage", gTonnage)
            intent.putExtra("iId", gId)
            intent.putExtra("iTruckRegNum", gTruckRegNum)
            intent.putExtra("iBodyType", gBodyType)
            intent.putExtra("iLength", gLength)

            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
      return this.products.size

    }
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var productRegNum = itemView.findViewById<TextView>(R.id.item_view_truck_reg_num)
        var productId = itemView.findViewById<TextView>(R.id.item_view_user_id)


    }

}