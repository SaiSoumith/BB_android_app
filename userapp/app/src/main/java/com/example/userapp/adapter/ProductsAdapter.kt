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
        holder.productName.text=product.name

        holder.itemView.setOnClickListener {

              val model   =products.get(position)
              var gEmail:String  =model.email
              var gId:String     =model.id.toString()
              var gName:String   =model.name
              var gPassword:String =model.password
              var gSchool:String =model.school

             val intent=Intent(context, ViewDetailsActivity::class.java)
            intent.putExtra("iEmail", gEmail)
            intent.putExtra("iName", gName)
            intent.putExtra("iId", gId)
            intent.putExtra("iPassword", gPassword)
            intent.putExtra("iSchool", gSchool)

            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
      return this.products.size

    }
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var productName = itemView.findViewById<TextView>(R.id.user_full_name)
        var productId = itemView.findViewById<TextView>(R.id.user_id)
    }

}