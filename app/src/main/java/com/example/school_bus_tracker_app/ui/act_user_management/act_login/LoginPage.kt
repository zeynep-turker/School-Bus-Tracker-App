package com.example.school_bus_tracker_app.ui.act_user_management.act_login
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.example.school_bus_tracker_app.R
import com.example.school_bus_tracker_app.core.BaseActivity
import com.example.school_bus_tracker_app.databinding.UserLoginPageLayoutBinding
import com.example.school_bus_tracker_app.enum.UserType
import com.example.school_bus_tracker_app.model.User
import com.example.school_bus_tracker_app.ui.act_driver.DriverHomePage
import com.example.school_bus_tracker_app.ui.act_parent.ParentHomePage
import com.example.school_bus_tracker_app.ui.act_student.StudentHomePage
import com.example.school_bus_tracker_app.ui.act_user_management.act_register.SignUpPage
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


private var email: String? = null
private var password: String? = null
private var mAuth: FirebaseAuth? = null
private var mDatabaseReference: DatabaseReference? = null
private var mDatabase: FirebaseDatabase? = null

class LoginPage : BaseActivity<UserLoginPageLayoutBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_login_page_layout)
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase?.reference?.child("Users")
        mAuth = FirebaseAuth.getInstance()

        binding.loginButton.setOnClickListener{
            confirmInput()
        }
        binding.signupTextButton.setOnClickListener {
            val intent = Intent(this, SignUpPage::class.java)
            startActivity(intent)
        }
    }
    override fun getLayout() = R.layout.user_login_page_layout
    private fun validateEmail(): Boolean {
        val emailInput: String = binding.email.editText?.text.toString().trim()
        if (emailInput.isEmpty()) {
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
        if (passwordInput.isEmpty()) {
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
        loginUser()
    }
    private fun loginUser() {
        email =  binding.email.editText?.text.toString()
        password = binding.password.editText?.text.toString()
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            Log.d("Main", "Logging in user.")
            mAuth?.let {
                it.signInWithEmailAndPassword(email!!, password!!)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with signed-in user's information
                        Log.d("Main", "signInWithEmail:success")
                        next()
                        //onStart()
                        //nextUI()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.e("Main", "signInWithEmail:failure", task.exception)
                        Toast.makeText(this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
            }
        } else {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show()
        }
    }
    fun next() {

        val mUser = mAuth?.let{it.currentUser}
        val mUserReference = mDatabaseReference?.let{ mDatabaseReference -> mUser?.uid?.let { mUser -> mDatabaseReference.child(mUser) } }

        mUserReference?.let {
            it.addValueEventListener(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
                override fun onDataChange(snapshot: DataSnapshot) {
                    val str : String = snapshot.child("userType").value as String
                    if(str == UserType.Parent.name)
                        updateUI<ParentHomePage>()
                    if(str == UserType.Driver.name)
                        updateUI<DriverHomePage>()
                    if(str == UserType.Student.name)
                        updateUI<StudentHomePage>()
                }
            })
        }
    }

    private fun nextUI() {
        //TODO
        updateUI<ParentHomePage>()
    }
}