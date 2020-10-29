package com.example.school_bus_tracker_app.ui.act_driver

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.school_bus_tracker_app.R
import com.example.school_bus_tracker_app.model.ServiceModel
import kotlinx.android.synthetic.main.service_card_view_layout.view.*

class ServiceAdapter(private val services : MutableList<ServiceModel>) : RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.service_card_view_layout,parent,false)
        return ServiceViewHolder(v)

    }

    override fun getItemCount(): Int {
        return services.size
    }
    fun add(item:ServiceModel, position:Int) {
        services.add(position, item)
        notifyItemInserted(position)
    }

    fun remove(item:ServiceModel) {
        val position = services.indexOf(item)
        services.removeAt(position)
        notifyItemRemoved(position)
    }
    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val service = services[position]
        holder.itemView.txtServiceName.text = service.name
        holder.itemView.participants_number.text = service.participantNumber.toString()
        holder.itemView.participants_request_number.text = service.participantRequestNumber.toString()

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context,"${service.name} Detail Page",Toast.LENGTH_SHORT).show()
            val intent = Intent(it.context, ServiceDetailPage::class.java)
            intent.putExtra("name",service.name)
            it.context.startActivity(intent)
        }
        holder.itemView.setOnLongClickListener {
            remove(service)
            return@setOnLongClickListener true
        }
    }


    class ServiceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}