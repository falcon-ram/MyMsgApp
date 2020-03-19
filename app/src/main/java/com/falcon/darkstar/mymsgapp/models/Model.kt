package com.falcon.darkstar.mymsgapp.models

import android.util.Log
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.Request.Builder


data class Hobby(var title: String)
data class ImgDataStore(var title: String, var URI: String)

object Supplier {
    val hobbies = listOf<Hobby>(
        Hobby("Swimming"),
        Hobby("Reading"),
        Hobby("Football"),
        Hobby("Gaming"),
        Hobby("Programming"),
        Hobby("Tenis"),
        Hobby("Golf")
    )

    val hobbies2 = mutableListOf<Hobby>()

    fun loadHobby() {
        hobbies2.add(Hobby("Swimming"))
        hobbies2.add(Hobby("Reading"))
        hobbies2.add(Hobby("Golf"))
        hobbies2.add(Hobby("Badminton"))
    }

    val imgData = mutableListOf<ImgDataStore>()

    fun loadImgData() {
        val client = OkHttpClient()

        val request: Request = Builder()
            .url("https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/Search/ImageSearchAPI?autoCorrect=false&pageNumber=1&pageSize=10&q=Taylor%20Swift&safeSearch=false")
            .get()
            .addHeader("x-rapidapi-host", "contextualwebsearch-websearch-v1.p.rapidapi.com")
            .addHeader("x-rapidapi-key", "f97b719c04msh11b9a010a2e8e58p14e85fjsna8561de07d0a")
            .build()

        val response = client.newCall(request).execute() // this call seems to cause an exception error
        val result : String = response!!.message().toString()
        Log.i("Model.kt", result)
    }
}