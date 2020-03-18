package com.falcon.darkstar.mymsgapp

import android.app.Activity
import android.widget.Toast
import android.widget.Toast.*

fun Activity.showToast(msg: String?) {
    makeText(this, msg, LENGTH_SHORT).show()
}