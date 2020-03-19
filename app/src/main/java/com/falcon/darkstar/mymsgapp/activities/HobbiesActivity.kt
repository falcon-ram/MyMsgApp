package com.falcon.darkstar.mymsgapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.falcon.darkstar.mymsgapp.adaptors.HobbiesAdaptor
import com.falcon.darkstar.mymsgapp.R
import com.falcon.darkstar.mymsgapp.models.Supplier
import kotlinx.android.synthetic.main.activity_hobbies.*

class HobbiesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        Supplier.loadHobby()
        //Supplier.loadImgData() // There is a network exception error in this function. Don't know why

        val adaptor = HobbiesAdaptor(
            this,
            Supplier.hobbies2
        )
        recyclerView.adapter = adaptor  // This recyclerView is from the activities_hobbies.xml
    }
}