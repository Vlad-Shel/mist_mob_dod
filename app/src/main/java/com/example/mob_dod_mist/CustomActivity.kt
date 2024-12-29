package com.example.mob_dod_mist

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CustomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)

        // Найдем кнопку по ID
        val backButton = findViewById<Button>(R.id.backButton)

        // Установим обработчик клика для возврата на предыдущий экран
        backButton.setOnClickListener {
            finish() // Закрываем текущую активность и возвращаемся назад
        }
    }
}
