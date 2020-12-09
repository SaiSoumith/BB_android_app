package com.example.userapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.userapp.R
import kotlinx.android.synthetic.main.activity_view_details.*

class ViewDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_details)

        val actionBar:ActionBar?=supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

          var intent=intent
        val vHeight=intent.getStringExtra("iHeight")
        val vId=intent.getStringExtra("iId")
        val vTonnage=intent.getStringExtra("iTonnage")
        val vTruckRegNum=intent.getStringExtra("iTruckRegNum")
        val vBodyType=intent.getStringExtra("iBodyType")
        val vLength=intent.getStringExtra("iLength")

        actionBar.setTitle(vId)
        a_id.text=vId
        a_height.text=vHeight
        a_tonnage.text=vTonnage
        a_truck_reg_num.text=vTruckRegNum
        a_body_type.text=vBodyType
        a_length.text=vLength

//
//
    }
}