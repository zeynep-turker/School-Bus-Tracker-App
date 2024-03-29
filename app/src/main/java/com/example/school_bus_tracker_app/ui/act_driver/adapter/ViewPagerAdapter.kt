package com.example.school_bus_tracker_app.ui.act_driver.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

@Suppress("DEPRECATION")
class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    private val fragmentList: MutableList<Fragment> = ArrayList()
    private val titleList: MutableList<String> = ArrayList()

    //Fragment'in pozisyonunu veriyoruz
    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }
    //Fragment sayısını veriyoruz
    override fun getCount(): Int {
        return fragmentList.size
    }
    //Bu fonksiyon ile Fragment'leri ve title'ları ekliyoruz
    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        titleList.add(title)
    }
    //Title'ların pozisyonunu veriyoruz
    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }
}