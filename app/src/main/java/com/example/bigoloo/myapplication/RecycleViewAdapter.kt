package com.example.bigoloo.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * Created by bigoloo on 12/23/17.
 */
class RecycleViewAdapter : RecyclerView.Adapter<RecycleViewAdapter.KViewHolder>() {

    lateinit var userList: List<User>
    fun addAll(list: List<User>) {
        userList = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: KViewHolder?, position: Int) {
        val item = userList[position]
        holder?.label?.text = item.description
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): KViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        val vh = KViewHolder(v)
        return vh
    }

    class KViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var label: TextView = itemView.findViewById<TextView>(android.R.id.text1)

    }

}