package com.samnn.appstoresimulation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.samnn.appstoresimulation.R
import com.samnn.appstoresimulation.models.App
import java.text.NumberFormat

class AppAdapter(val context: Context, val apps: ArrayList<App>) :
    RecyclerView.Adapter<AppAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logo: ImageView = itemView.findViewById(R.id.app_icon)
        val name: TextView = itemView.findViewById(R.id.app_name)
        val star: TextView = itemView.findViewById(R.id.app_star)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.app_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = apps.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val app = apps[position]
        holder.name.text = app.name
        val starFormat = NumberFormat.getInstance()
        starFormat.maximumFractionDigits = 1
        starFormat.minimumFractionDigits = 1
        holder.star.text = starFormat.format(app.star)
        holder.logo.setImageResource(app.logoID)
    }
}