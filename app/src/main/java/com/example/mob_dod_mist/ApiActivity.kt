package com.example.mob_dod_mist

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ApiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)

        // Найти ListView
        val listView = findViewById<ListView>(R.id.apiListView)

        // Временные данные (заглушка)
        val dummyData = listOf("Элемент 1", "Элемент 2", "Элемент 3", "Элемент 4")

        // Настройка адаптера для отображения данных
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dummyData)
        listView.adapter = adapter
    }
}
