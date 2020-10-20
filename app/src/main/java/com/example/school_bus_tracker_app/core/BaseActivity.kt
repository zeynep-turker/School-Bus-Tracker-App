package com.example.school_bus_tracker_app.core
import android.app.Activity
import android.content.Intent
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<DB : ViewDataBinding>() : AppCompatActivity() {
    @LayoutRes
    abstract fun getLayout(): Int


    val binding by lazy {
        DataBindingUtil.setContentView(this, getLayout()) as DB
    }
    inline fun <reified T : Activity> updateUI() {
        val intent = Intent(this, T::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        //startActivity(Intent(this, T::class.java))
        finish()
    }
}