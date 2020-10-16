package com.example.school_bus_tracker_app

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class BaseViewModel {
    open class BaseViewModel(app: Application) : AndroidViewModel(app)
}