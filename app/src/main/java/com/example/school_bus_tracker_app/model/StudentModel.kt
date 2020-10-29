package com.example.school_bus_tracker_app.model

class StudentModel : User(){
    var status: String = ""
    var schoolName : String = ""
    fun init(name2 : String) {
        name = name2
    }
}
