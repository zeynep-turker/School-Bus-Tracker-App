package com.example.school_bus_tracker_app

import android.os.Bundle
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
}