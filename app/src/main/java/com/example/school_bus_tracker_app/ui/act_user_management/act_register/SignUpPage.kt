package com.example.school_bus_tracker_app.ui.act_user_management.act_register

import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import com.example.school_bus_tracker_app.core.BaseActivity
import com.example.school_bus_tracker_app.R
import com.example.school_bus_tracker_app.databinding.UserSignupPageLayoutBinding
import com.example.school_bus_tracker_app.model.DriverModel
import com.example.school_bus_tracker_app.model.ParentModel
import com.example.school_bus_tracker_app.model.StudentModel
import com.example.school_bus_tracker_app.model.User
import com.example.school_bus_tracker_app.ui.act_student.StudentHomePage
import com.example.school_bus_tracker_app.ui.act_user_management.act_login.LoginPage
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpPage : BaseActivity<UserSignupPageLayoutBinding>() {
    private lateinit var emailInput: String
    private lateinit var passwordInput: String
    private lateinit var ageInput: String
    private lateinit var telephoneNumberInput : String
    lateinit var radioButton: RadioButton
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_signup_page_layout)
        binding.signupButton.setOnClickListener {
            confirmInput()
        }
        binding.loginTextButton.setOnClickListener {
            updateUI<LoginPage>()
        }

    }
    override fun getLayout() = R.layout.user_signup_page_layout

    private fun validateEmail(): Boolean {
        emailInput = binding.userEmail.editText?.text.toString().trim()
        return if (emailInput.isEmpty()) {
            binding.userEmail.error = "Field can't be empty"
            false
        } else {
            binding.userEmail.error = null
            true
        }
    }
    private fun validatePassword(): Boolean {
        passwordInput = binding.password.editText?.text.toString().trim()
        return when {
            passwordInput.isEmpty() -> {
                binding.password.error = "Field can't be empty"
                false
            }
            passwordInput.length < 6 -> {
                binding.password.error = "Password cannot be less than 6 characters"
                false
            }
            else -> {
                binding.password.error = null
                true
            }
        }
    }
    private fun validateAge(): Boolean {
        ageInput =
            binding.userAge.editText?.text.toString().trim()
        return if (ageInput.isEmpty()) {
            binding.userAge.error = "Field can't be empty"
            false
        } else {
            binding.userAge.error = null
            true
        }
    }
    private fun validateTelephoneNumber(): Boolean {
        telephoneNumberInput =
            binding.userTelephoneNumber.editText?.text.toString().trim()
        return if (telephoneNumberInput.isEmpty()) {
            binding.userTelephoneNumber.error = "Field can't be empty"
            false
        } else {
            binding.userTelephoneNumber.error = null
            true
        }
    }
    private fun confirmInput() {
        if (!validateEmail()  or !validatePassword() or !validateAge() or !validateTelephoneNumber())  {
            return
        }
        val user: User
        mDatabase = FirebaseDatabase.getInstance()

        val selectedOption: Int = binding.radioGroup.checkedRadioButtonId
        radioButton = findViewById(selectedOption)
        mDatabaseReference = when (radioButton.text) {
            "Driver" -> {
                user = DriverModel()
                mDatabase!!.reference.child("Users")//.child("Driver")
            }
            "Parent" -> {
                user = ParentModel()
                mDatabase!!.reference.child("Users")//.child("Parent")
            }
            else -> {
                user = StudentModel()
                mDatabase!!.reference.child("Users")//.child("Student")
            }
        }
        user.init(radioButton.text as String,emailInput,ageInput,telephoneNumberInput,passwordInput)
        mAuth = FirebaseAuth.getInstance()
        performRegister(user)
    }
    private fun performRegister(user : User){
        mAuth!!
            .createUserWithEmailAndPassword(user.email, user.password)
            .addOnCompleteListener(this) {
                if (!it.isSuccessful) return@addOnCompleteListener

                val userId = mAuth!!.currentUser!!.uid

                var currentUserDb = mDatabaseReference!!.child(userId)
                currentUserDb.child("userType").setValue(user.userType)
                currentUserDb.child("email").setValue(user.email)
                currentUserDb.child("age").setValue(user.age)
                currentUserDb.child("telephoneNumber").setValue(user.telephoneNumber)
                currentUserDb.child("password").setValue(user.password)
                currentUserDb.child("name").setValue(user.name)
                currentUserDb.child("lat").setValue(user.lat)
                currentUserDb.child("long").setValue(user.long)
                currentUserDb.child("imageUrl").setValue(user.imageURL)

                when (radioButton.text) {
                    "Driver" -> {
                        currentUserDb.child("schoolName").setValue((user as DriverModel).schoolName)
                        currentUserDb.child("status").setValue((user).status)

                    }
                    "Parent" -> {
                        currentUserDb.child("Children").setValue("true")
                    }
                    else -> {
                        currentUserDb.child("schoolName").setValue((user as StudentModel).schoolName)
                        currentUserDb.child("status").setValue((user).status)
                    }
                }
                updateUI<LoginPage>()
            }
            .addOnFailureListener{
                Log.d("Main", "Failed to create user: ${it.message}")
                Toast.makeText(this, "Failed to create user: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }
}