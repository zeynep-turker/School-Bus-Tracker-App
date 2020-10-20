package com.example.school_bus_tracker_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.school_bus_tracker_app.ui.act_user_management.UserManagement


class MainActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        finish()
        val intent = Intent(this, UserManagement::class.java)
        startActivity(intent)
    }
}
