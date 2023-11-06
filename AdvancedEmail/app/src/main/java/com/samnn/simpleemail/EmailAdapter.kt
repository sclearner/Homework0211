package com.samnn.simpleemail

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class EmailAdapter(val context: Context, val emails: ArrayList<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    public class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sender: TextView = itemView.findViewById(R.id.source)
        val subject: TextView = itemView.findViewById(R.id.subject)
        val content: TextView = itemView.findViewById(R.id.content)
        val time: TextView = itemView.findViewById(R.id.time)
        val star: CheckBox = itemView.findViewById(R.id.star)
        val important: CheckBox = itemView.findViewById(R.id.important)
        val avatar: TextView = itemView.findViewById(R.id.avatar)
        val avatarTheme: FrameLayout = itemView.findViewById(R.id.avatar_frame)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailAdapter.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.email_item, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: EmailAdapter.ViewHolder, position: Int) {
        val email = emails[position]
        holder.sender.text = email.sender
        holder.subject.text = email.subject
        holder.content.text = email.content
        holder.time.text = formatTime(email.time)

        holder.star.isChecked = email.isStarred
        holder.star.setOnClickListener {
            emails[position].isStarred = (it as CheckBox).isChecked
        }

        holder.important.isChecked = email.isImportant
        holder.important.setOnClickListener {
            emails[position].isImportant = (it as CheckBox).isChecked
        }

        holder.avatar.text = email.sender[0].uppercase()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.avatarTheme.setBackgroundColor(email.avatarColor)
        }
    }

    private fun formatTime(date: Date): String {
        val now = Calendar.getInstance()
        val pattern: String =
            if (date.year != now.time.year) {
                "dd/MM/yy"
            }
            else if (date.date != now.time.date) {
                "dd MMM"
            }
            else {
                "h:mm a"
            }
        val format = SimpleDateFormat(pattern, Locale("vi", "VN"))
        return format.format(date)
    }

    override fun getItemCount() = emails.size

}