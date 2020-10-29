package com.example.school_bus_tracker_app.ui.act_driver

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.school_bus_tracker_app.R
import com.example.school_bus_tracker_app.core.BaseActivity
import com.example.school_bus_tracker_app.databinding.ServiceListRecyclerviewLayoutBinding
import com.example.school_bus_tracker_app.model.ServiceModel

class DriverServiceListPage : BaseActivity<ServiceListRecyclerviewLayoutBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.service_list_recyclerview_layout)
        binding.recylerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recylerView.adapter = ServiceAdapter(getServices())
    }
    override fun getLayout() = R.layout.service_list_recyclerview_layout
    private fun getServices(): MutableList<ServiceModel> {
        return mutableListOf(
            ServiceModel("Service 1",10,5),
            ServiceModel("Service 2",10,6),
            ServiceModel("Service 3",10,7),
            ServiceModel("Service 4",10,8),
            ServiceModel("Service 5",10,9),
            ServiceModel("Service 6",10,10),
            ServiceModel("Service 7",10,11),
            ServiceModel("Service 8",10,12),
            ServiceModel("Service 9",10,13),
            ServiceModel("Service 10",10,5),
            ServiceModel("Service 11",10,6),
            ServiceModel("Service 12",10,7),
            ServiceModel("Service 13",10,8),
            ServiceModel("Service 14",10,7),
            ServiceModel("Service 15",10,8)
        )
    }
}