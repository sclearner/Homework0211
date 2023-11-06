package com.samnn.simpleemail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emails = arrayListOf<Email>()
        repeat(100) {
            val email = Email(
                "Hanoi@gmail.com",
                "Chào mừng bạn đến với thủ đô!",
                "Hãy làm quen dần với đặc sản tắc đường",
                Calendar.getInstance().time
            )
            emails.add(email)
            Log.i(null, email.toString())
        }

        val recyclerView = findViewById<RecyclerView>(R.id.email_list)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EmailAdapter(this, emails)
    }
}