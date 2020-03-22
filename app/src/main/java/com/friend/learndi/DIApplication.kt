package com.friend.learndi

import android.app.Application
import com.friend.learndi.di.DaggerApplicationComponent

// applicationGraph lives in the Application class to share its lifecycle
class DIApplication : Application() {
    // Reference to the application graph that is used across the whole app
    val appComponent = DaggerApplicationComponent.create()
}