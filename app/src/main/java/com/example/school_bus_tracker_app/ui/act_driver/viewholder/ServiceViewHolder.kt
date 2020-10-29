package com.example.school_bus_tracker_app.ui.act_driver.viewholder

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.school_bus_tracker_app.R
import com.example.school_bus_tracker_app.model.ServiceModel
import com.example.school_bus_tracker_app.ui.act_driver.ServiceDetailPage

class ServiceViewHolder (viewGroup: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(viewGroup.context)
    .inflate(R.layout.service_card_view_layout, viewGroup, false)) {


    fun bindTo(dataDTO: ServiceModel, onItemClick: (view: View, newsDTO: ServiceModel) -> Unit) {

        //databseden gelene veriyi kendi uygulamammızin içerisine burda yediriyoruz


        //setOnClickListener eklenerek verilerin tasimasi saglanir
        itemView.setOnClickListener {

            val intent = Intent(it.context, ServiceDetailPage::class.java)

            //Detail sayfasına gonderdigimiz verileri put extra kullanarak göndericez.
          /*  intent.putExtra("newtitle", dataDTO.newtitle);
            intent.putExtra("newdescrip", dataDTO.newdescrip);
            intent.putExtra("newimageurl", dataDTO.newimageurl);*/

            it.context.startActivity(intent)
            onItemClick(it, ServiceModel())
        }
    }

}