package com.samnn.appstoresimulation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.samnn.appstoresimulation.adapter.ListAppAdapter
import com.samnn.appstoresimulation.models.App
import com.samnn.appstoresimulation.models.AppCategory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.open_search_view_toolbar))
        setSupportActionBar(findViewById(R.id.bottomAppBar))

        val appCategories = arrayListOf<AppCategory>()

        repeat(100) { cit ->
            val apps = arrayListOf<App>()
            repeat(100) {
                val current = App(
                    R.mipmap.ic_launcher,
                    "App ${it + 1}",
                    (10..50).random() / 10.0              )
                apps.add(current)
            }
            val current = AppCategory("Category ${cit + 1}", apps)
            appCategories.add(current)
        }

        val listAppList: RecyclerView = findViewById(R.id.list_app_list)
        listAppList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        listAppList.adapter = ListAppAdapter(this, appCategories)
    }
}