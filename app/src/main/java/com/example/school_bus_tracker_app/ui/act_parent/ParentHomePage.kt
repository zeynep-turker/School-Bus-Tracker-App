package com.example.school_bus_tracker_app.ui.act_parent

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.school_bus_tracker_app.R
import com.example.school_bus_tracker_app.core.BaseActivity
import com.example.school_bus_tracker_app.databinding.ParentHomePageLayoutBinding

class ParentHomePage : BaseActivity<ParentHomePageLayoutBinding>(){
    private val itemList=mutableListOf("Age","Age","Age")
    private var adapter : ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.parent_home_page_layout)
        adapter=ArrayAdapter(this, R.layout.card_view_item_layout, R.id.text, itemList)
        binding.listView.adapter = adapter
        binding.button.setOnClickListener{
            addAChildDialog()
        }
    }
    override fun getLayout() = R.layout.parent_home_page_layout
    private fun addAChildDialog(){
        val addChildDialog = AlertDialog.Builder(this)
        val myview : View = layoutInflater.inflate(R.layout.add_child_layout,null)
        addChildDialog.setView(myview)
        addChildDialog.setCancelable(false)
        addChildDialog.setPositiveButton("OK") { dialog, _ ->
            val newItem = "Age"
            itemList.add(newItem)
            adapter?.notifyDataSetChanged()
            Toast.makeText(this, "Child is added", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addChildDialog.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        addChildDialog.show().window?.setBackgroundDrawableResource(R.drawable.round_corner)
    }
}