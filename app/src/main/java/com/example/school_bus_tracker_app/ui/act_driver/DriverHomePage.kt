package com.example.school_bus_tracker_app.ui.act_driver

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import com.example.school_bus_tracker_app.R
import com.example.school_bus_tracker_app.core.BaseActivity
import com.example.school_bus_tracker_app.databinding.DriverHomePageLayoutBinding
import kotlinx.android.synthetic.main.add_child_layout.view.*


class DriverHomePage : BaseActivity<DriverHomePageLayoutBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.driver_home_page_layout)
        binding.createService.setOnClickListener {
            createService()
        }
        binding.myServices.setOnClickListener {
            val intent = Intent(this, DriverServiceListPage::class.java)
            startActivity(intent)
        }
    }

    override fun getLayout() = R.layout.driver_home_page_layout

    private fun createService(){
        val mDialogView = layoutInflater.inflate(R.layout.create_service_dialog_layout,null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setCancelable(false)
        val mAlertDialog = mBuilder.show()
        mDialogView.okey.setOnClickListener {
            mAlertDialog.dismiss()
        }
        mDialogView.cancel.setOnClickListener {
            mAlertDialog.dismiss()
        }
        mAlertDialog.window?.setBackgroundDrawableResource(R.drawable.round_corner)
    }

}