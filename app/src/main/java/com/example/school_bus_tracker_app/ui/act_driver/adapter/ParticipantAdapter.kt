package com.example.school_bus_tracker_app.ui.act_driver.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.school_bus_tracker_app.R
import com.example.school_bus_tracker_app.model.StudentModel
import kotlinx.android.synthetic.main.participant_card_view_layout.view.*

class ParticipantAdapter (private val participants : MutableList<StudentModel>) : RecyclerView.Adapter<ParticipantAdapter.ParticipantViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParticipantViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.participant_card_view_layout,parent,false)
        return ParticipantViewHolder(v)
    }

    override fun getItemCount(): Int {
        return participants.size
    }
    fun add(item: StudentModel, position:Int) {
        participants.add(position, item)
        notifyItemInserted(position)
    }

    fun remove(item: StudentModel) {
        val position = participants.indexOf(item)
        participants.removeAt(position)
        //notifyItemRemoved(position)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: ParticipantViewHolder, position: Int) {
        val participant = participants[position]
        holder.itemView.txtParticipantName.text = participant.name

        holder.itemView.setOnClickListener {
           /* Toast.makeText(holder.itemView.context,"${participant.name} Detail Page", Toast.LENGTH_SHORT).show()
            val intent = Intent(it.context, ServiceDetailPage::class.java)
            intent.putExtra("name",participant.name)
            it.context.startActivity(intent)*/
        }
        holder.itemView.setOnLongClickListener {
            remove(participant)
            return@setOnLongClickListener true
        }
    }


    class ParticipantViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}