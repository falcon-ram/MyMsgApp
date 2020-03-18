package com.falcon.darkstar.mymsgapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            // Code
            Log.i("MainActivity", "Button was clicked!")

            Toast.makeText(this, "Button was clicked!", Toast.LENGTH_SHORT).show()
        }

        btnSendMsgToNextActivity.setOnClickListener {
            val message : String = edtUserMessage.text.toString()
            //Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            val tmpIntent = Intent(this, SecondActivity::class.java) // Explicit intent
            tmpIntent.putExtra("user_message", message)

            startActivity(tmpIntent)
        }

        btnShareToOtherApps.setOnClickListener {
            // Implicit Intent -- used to share data to other apps
            val message : String = edtUserMessage.text.toString()

            val tmpIntent = Intent()
            tmpIntent.action = Intent.ACTION_SEND
            tmpIntent.putExtra(Intent.EXTRA_TEXT, message)
            tmpIntent.type = "text/plain"

            startActivity(Intent.createChooser(tmpIntent, "Share to: "))
        }

        btnRecyclerViewDemo.setOnClickListener {
            val tmpIntent = Intent(this, HobbiesActivity::class.java)
            startActivity(tmpIntent)
        }
    }
}
