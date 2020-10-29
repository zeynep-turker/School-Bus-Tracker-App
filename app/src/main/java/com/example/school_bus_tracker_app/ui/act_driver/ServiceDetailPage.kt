package com.example.school_bus_tracker_app.ui.act_driver

import android.os.Bundle
import com.example.school_bus_tracker_app.R
import com.example.school_bus_tracker_app.core.BaseActivity
import com.example.school_bus_tracker_app.databinding.ServiceDetailPageLayoutBinding
import com.example.school_bus_tracker_app.ui.act_driver.adapter.ViewPagerAdapter


class ServiceDetailPage : BaseActivity<ServiceDetailPageLayoutBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.service_detail_page_layout)
        binding.serviceName.text = intent.extras?.get("name").toString()

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ParticipantListPage(), "Participants")
        adapter.addFragment(WaitingParticipantListPage(), "Waiting Requests")

        //Adapter'ımızdaki verileri viewPager adapter'a veriyoruz
        binding.viewPager.adapter = adapter
        //Tablar arasında yani viewPager'lar arasında geçisi sağlıyoruz
        binding.tabs.setupWithViewPager(binding.viewPager)
    }

    override fun getLayout() = R.layout.service_detail_page_layout

}