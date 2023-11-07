package com.samnn.appstoresimulation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.samnn.appstoresimulation.R
import com.samnn.appstoresimulation.models.AppCategory

class ListAppAdapter(val context: Context, val appCategories: ArrayList<AppCategory>) :
    RecyclerView.Adapter<ListAppAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.app_category_name)
        val appList: RecyclerView = itemView.findViewById(R.id.app_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.app_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = appCategories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val appCategory = appCategories[position]
        holder.title.text = appCategory.name
        holder.appList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.appList.adapter = AppAdapter(context, appCategory.apps)
    }
}