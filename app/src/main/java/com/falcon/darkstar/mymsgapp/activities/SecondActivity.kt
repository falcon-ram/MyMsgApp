package com.falcon.darkstar.mymsgapp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.falcon.darkstar.mymsgapp.R
import com.falcon.darkstar.mymsgapp.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras
        //val msg = bundle!!.getString("user_message") // !! = Not NULL

        // Safe call with let. This will only execute the lambda function if the
        // bundle != null
        bundle?.let {
            val msg = bundle.getString("user_message") // !! = Not NULL
            showToast(msg)
            //Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

            txtUserMessage.text = msg
        }


    }
}