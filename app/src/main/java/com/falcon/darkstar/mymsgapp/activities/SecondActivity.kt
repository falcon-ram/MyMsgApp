package com.falcon.darkstar.mymsgapp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.falcon.darkstar.mymsgapp.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras
        val msg = bundle!!.getString("user_message") // !! = Not NULL

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

        txtUserMessage.text = msg
    }
}