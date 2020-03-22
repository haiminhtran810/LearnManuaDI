package com.friend.learndi

import android.app.Application
import com.friend.learndi.di.DaggerApplicationGraph

// applicationGraph lives in the Application class to share its lifecycle
class DIApplication : Application() {
    // Reference to the application graph that is used across the whole app
    val applicationGraph = DaggerApplicationGraph.create()
}