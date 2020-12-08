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
        val vName=intent.getStringExtra("iName")
        val vId=intent.getStringExtra("iId")
        val vEmail=intent.getStringExtra("iEmail")
        val vPassword=intent.getStringExtra("iPassword")
        val vSchool=intent.getStringExtra("iSchool")

        actionBar.setTitle(vId)
        a_user_id.text=vId
        a_user_full_name.text=vName
        a_email.text=vEmail
        a_password.text=vPassword
        a_school.text=vSchool


    }
}