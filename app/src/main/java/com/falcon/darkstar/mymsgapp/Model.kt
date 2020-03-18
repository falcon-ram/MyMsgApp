package com.falcon.darkstar.mymsgapp

data class Hobby(var title: String)

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
}