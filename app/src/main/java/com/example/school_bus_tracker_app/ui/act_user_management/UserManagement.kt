package com.example.school_bus_tracker_app.ui.act_user_management
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.school_bus_tracker_app.BaseActivity
import com.example.school_bus_tracker_app.ui.act_user_management.act_login.LoginPage
import com.example.school_bus_tracker_app.R
import com.example.school_bus_tracker_app.databinding.UserLoginSignupPageLayoutBinding

class UserManagement : BaseActivity<UserLoginSignupPageLayoutBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_login_signup_page_layout)

        binding.loginButton.setOnClickListener{
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }
        binding.sigupButton.setOnClickListener{
        }
    }
    override fun getLayout() = R.layout.user_login_signup_page_layout

}