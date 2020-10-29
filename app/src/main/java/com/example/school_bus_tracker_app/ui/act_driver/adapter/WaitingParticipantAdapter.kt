package com.example.school_bus_tracker_app.ui.act_driver.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.school_bus_tracker_app.R
import com.example.school_bus_tracker_app.model.StudentModel
import kotlinx.android.synthetic.main.waiting_participant_card_view_layout.view.*

class WaitingParticipantAdapter (private val waitingParticipants : MutableList<StudentModel>) : RecyclerView.Adapter<WaitingParticipantAdapter.WaitingParticipantViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WaitingParticipantViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.waiting_participant_card_view_layout, parent, false)
        return WaitingParticipantViewHolder(v)
    }

    override fun getItemCount(): Int {
        return waitingParticipants.size
    }
    fun add(item: StudentModel, position:Int) {
        waitingParticipants.add(position, item)
        notifyItemInserted(position)
    }
    fun remove(item: StudentModel) {
        val position = waitingParticipants.indexOf(item)
        waitingParticipants.removeAt(position)
        notifyItemRemoved(position)
    }
    override fun onBindViewHolder(holder: WaitingParticipantViewHolder, position: Int) {
        val participant = waitingParticipants[position]
        holder.itemView.txtWaitingParticipantName.text = participant.name
        holder.itemView.setOnClickListener {
            /* Toast.makeText(holder.itemView.context,"${participant.name} Detail Page", Toast.LENGTH_SHORT).show()
             val intent = Intent(it.context, ServiceDetailPage::class.java)
             intent.putExtra("name",participant.name)
             it.context.startActivity(intent)*/
        }
        holder.itemView.delete_btn.setOnClickListener {
            remove(participant)
        }


    }
    class WaitingParticipantViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}