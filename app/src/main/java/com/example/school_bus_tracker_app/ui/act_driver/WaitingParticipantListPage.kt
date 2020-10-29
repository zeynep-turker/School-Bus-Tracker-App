package com.example.school_bus_tracker_app.ui.act_driver
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.school_bus_tracker_app.R
import com.example.school_bus_tracker_app.databinding.ParticipantListRecylerviewLayoutBinding
import com.example.school_bus_tracker_app.databinding.ServiceListRecyclerviewLayoutBinding
import com.example.school_bus_tracker_app.model.StudentModel
import com.example.school_bus_tracker_app.ui.act_driver.adapter.ParticipantAdapter
import com.example.school_bus_tracker_app.ui.act_driver.adapter.WaitingParticipantAdapter
import kotlinx.android.synthetic.main.service_list_recyclerview_layout.view.*

class WaitingParticipantListPage : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : ParticipantListRecylerviewLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.participant_list_recylerview_layout, container, false);
        binding.recylerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        binding.recylerView.adapter = WaitingParticipantAdapter(getWaitingParticipants())

        return binding.root
    }
    private fun getWaitingParticipants(): MutableList<StudentModel> {
        val user = StudentModel()
        user.init("Student 1")
        val user2 = StudentModel()
        user2.init("Student 2")
        val user3 = StudentModel()
        user3.init("Student 3")
        val user4 = StudentModel()
        user4.init("Student 4")
        val user5 = StudentModel()
        user5.init("Student 5")
        val user6 = StudentModel()
        user6.init("Student 6")
        val user7 = StudentModel()
        user7.init("Student 7")
        val user8 = StudentModel()
        user8.init("Student 8")
        val user9 = StudentModel()
        user9.init("Student 9")
        val user10 = StudentModel()
        user10.init("Student 10")

        return mutableListOf(user,user2,user3,user4,user5,user6,user7,user8,user9,user10)
    }
}