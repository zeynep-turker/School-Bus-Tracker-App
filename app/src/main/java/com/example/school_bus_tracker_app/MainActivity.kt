package com.example.school_bus_tracker_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.school_bus_tracker_app.ui.act_user_management.UserManagement
import com.example.school_bus_tracker_app.ui.act_user_management.act_login.LoginPage


class MainActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, UserManagement::class.java)
        startActivity(intent)
    }
}
