package com.example.school_bus_tracker_app.ui.act_student

import android.os.Bundle
import com.example.school_bus_tracker_app.core.BaseActivity
import com.example.school_bus_tracker_app.R
import com.example.school_bus_tracker_app.databinding.StudentHomePageLayoutBinding

class StudentHomePage : BaseActivity<StudentHomePageLayoutBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.student_home_page_layout)
    }

    override fun getLayout() = R.layout.student_home_page_layout

}