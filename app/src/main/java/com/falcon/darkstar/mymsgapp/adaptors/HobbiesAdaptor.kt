package com.falcon.darkstar.mymsgapp.adaptors

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.falcon.darkstar.mymsgapp.models.Hobby
import com.falcon.darkstar.mymsgapp.R
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdaptor(val context: Context, private val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdaptor.MyViewHolder>() {

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private var currentHobby: Hobby? = null
        private var currentPosition: Int = 0

        init {
            itemView.setOnClickListener{
                currentHobby?.let {
                    Toast.makeText(context, currentHobby!!.title + " Clicked! ", Toast.LENGTH_SHORT).show()
                }
            }

            itemView.imgShare.setOnClickListener {
                currentHobby?.let {
                    val message : String = "My Hobby is: " + currentHobby!!.title

                    val tmpIntent = Intent()
                    tmpIntent.action = Intent.ACTION_SEND
                    tmpIntent.putExtra(Intent.EXTRA_TEXT, message)
                    tmpIntent.type = "text/plain"

                    context.startActivity(Intent.createChooser(tmpIntent, "Share to: "))
                }

            }
        }

        fun setData(hobby: Hobby?, pos : Int) {
            hobby?.let {
                itemView.txvTitle.text = hobby.title

                this.currentHobby = hobby
                this.currentPosition = pos
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }
}