package com.example.school_bus_tracker_app.parent

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.school_bus_tracker_app.R

class ParentHomePage : AppCompatActivity(){
    private val itemList=mutableListOf("Age","Age","Age")
    private var adapter : ArrayAdapter<String>? = null

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.parent_home_page_layout)
        val listV= findViewById<ListView>(R.id.listView)
          adapter=ArrayAdapter<String>(this, R.layout.card_view_item_layout, R.id.text, itemList)
          listV.adapter = adapter

        val btAdd= findViewById<Button>(R.id.button)
        btAdd.setOnClickListener{
            addAChild()
        }

    }
    private fun addAChild(){
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