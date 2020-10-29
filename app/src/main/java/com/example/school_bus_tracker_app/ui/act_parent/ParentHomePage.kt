package com.example.school_bus_tracker_app.ui.act_parent

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.school_bus_tracker_app.R
import com.example.school_bus_tracker_app.core.BaseActivity
import com.example.school_bus_tracker_app.databinding.ParentHomePageLayoutBinding
import com.example.school_bus_tracker_app.enum.UserType
import com.example.school_bus_tracker_app.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.add_child_layout.view.*


class ParentHomePage : BaseActivity<ParentHomePageLayoutBinding>(){
    private val itemList=mutableListOf("Age","Age","Age")
    private var adapter : ArrayAdapter<String>? = null
    private var mAuth: FirebaseAuth? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mDatabaseReference: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.parent_home_page_layout)
        mAuth = FirebaseAuth.getInstance()
        adapter=ArrayAdapter(this, R.layout.card_view_item_layout, R.id.text, itemList)
        binding.listView.adapter = adapter
        binding.button.setOnClickListener{
            addChild()
        }
    }
    private fun addChild(){
        val mDialogView = layoutInflater.inflate(R.layout.add_child_layout,null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setCancelable(false)

        val mAlertDialog = mBuilder.show()
        mDialogView.okey.setOnClickListener {
            mAlertDialog.dismiss()
            /*val email = mDialogView.child_email.text.toString()
            val password  = mDialogView.child_password.text.toString()
            Toast.makeText(this, "email : $email password $password", Toast.LENGTH_LONG).show()
            mDatabase = FirebaseDatabase.getInstance()
            mDatabaseReference =  mDatabase!!.reference.child("Users")
            val userID = mAuth!!.currentUser!!.uid
            mAuth?.let {
                it.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with signed-in user's information
                            Log.d("Main", "signInWithEmail:success")
                            Toast.makeText(this, "Child is  found.",
                                Toast.LENGTH_SHORT).show()
                            val child : User
                            val mUser = mAuth?.let{it.currentUser}
                            val mUserReference = mDatabaseReference?.let{ mDatabaseReference -> mUser?.uid?.let { mUser -> mDatabaseReference.child(mUser) } }
                            mUserReference?.let { databaseReference ->
                                databaseReference.addValueEventListener(object : ValueEventListener {
                                    override fun onCancelled(error: DatabaseError) {
                                        TODO("Not yet implemented")
                                    }
                                    override fun onDataChange(snapshot: DataSnapshot) {
                                        val str : String = snapshot.child("userType").value as String
                                        if(str == UserType.Student.name) {

                                            if (mUser != null) {
                                                Log.d("ParenHomePage","Child is found. ${mUser.uid}")
                                            }
                                        }
                                        else
                                            Log.d("ParenHomePage","Child is not found.")
                                    }
                                })
                            }

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(this, "Child is not found.",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
            }*/

        }
        mDialogView.cancel.setOnClickListener {
            mAlertDialog.dismiss()
        }
        mAlertDialog.window?.setBackgroundDrawableResource(R.drawable.round_corner)

    }

    override fun getLayout() = R.layout.parent_home_page_layout
}