package com.example.school_bus_tracker_app.model

open class User{
    var email: String = ""
    var age: String = ""
    var telephoneNumber: String = ""
    var password: String = ""
    var name: String = ""
    var imageURL: String = ""
    var lat : String = ""
    var long : String = ""
    var userType : String = ""
    fun init(userTypeInput:String, emailInput:String, ageInput : String, telephoneNumberInput : String, passwordInput : String) {
        userType = userTypeInput
        email = emailInput
        age = ageInput
        telephoneNumber = telephoneNumberInput
        password = passwordInput
    }

}
