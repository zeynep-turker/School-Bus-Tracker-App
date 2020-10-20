package com.example.school_bus_tracker_app.ui.act_driver

import android.os.Bundle
import com.example.school_bus_tracker_app.R
import com.example.school_bus_tracker_app.core.BaseActivity
import com.example.school_bus_tracker_app.databinding.DriverHomePageLayoutBinding

class DriverHomePage : BaseActivity<DriverHomePageLayoutBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.driver_home_page_layout)
    }

    override fun getLayout() = R.layout.driver_home_page_layout
}