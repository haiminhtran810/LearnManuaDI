package com.friend.learndi

import android.app.Application
// Instance of AppContainer that will be used by all the Activities of the app
class DIApplication : Application() {
    val appContainer = AppContainer()
}