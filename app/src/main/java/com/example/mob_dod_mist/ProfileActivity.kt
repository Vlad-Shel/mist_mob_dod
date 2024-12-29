package com.example.mob_dod_mist

import android.util.Log

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Найдите элементы макета
        val profilePhoto = findViewById<ImageView>(R.id.profilePhoto)
        val profileName = findViewById<TextView>(R.id.profileName)
        val profileGroup = findViewById<TextView>(R.id.profileGroup)
        val profileDescription = findViewById<TextView>(R.id.profileDescription)

        Log.d("ProfileActivity", "Загружается фотография и данные профиля")

        // Установите данные
        profilePhoto.setImageResource(R.drawable.foto_studenta) // Убедитесь, что файл существует
        profileName.text = getString(R.string.profile_name)
        profileGroup.text = getString(R.string.profile_group)
        profileDescription.text = getString(R.string.profile_description)

        Log.d("ProfileActivity", "Фотография и данные загружены")
    }


}
