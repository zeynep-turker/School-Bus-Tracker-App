package com.example.school_bus_tracker_app.ui.act_user_management.act_login
import android.os.Bundle
import android.widget.Toast
import com.example.school_bus_tracker_app.BaseActivity
import com.example.school_bus_tracker_app.R
import com.example.school_bus_tracker_app.databinding.UserLoginPageLayoutBinding


class LoginPage : BaseActivity<UserLoginPageLayoutBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_login_page_activity)
        binding.loginButton.setOnClickListener{
            confirmInput()
        }
    }
    override fun getLayout() = R.layout.user_login_page_layout
    private fun validateEmail(): Boolean {
        val emailInput: String = binding.email.editText?.text.toString().trim()
        return if (emailInput.isEmpty()) {
            binding.email.error = "Field can't be empty"
            return false
        } else {
            binding.email.error = null
            return true
        }
    }
    private fun validatePassword(): Boolean {
        val passwordInput: String =
            binding.password.editText?.text.toString().trim()
        return if (passwordInput.isEmpty()) {
            binding.password.error = "Field can't be empty"
            return false
        } else {
            binding.password.error = null
            return true
        }
    }
    private fun confirmInput() {
        if (!validateEmail()  or !validatePassword()) {
            return
        }
        var input = "Email: " + binding.email.editText?.text.toString()
        input += "\n"
        input += "Password: " + binding.password.editText?.text.toString()
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show()
    }
}