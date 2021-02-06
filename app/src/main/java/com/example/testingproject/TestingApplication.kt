package com.example.testingproject

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.View

class TestingApplication : Application() {
    val TAG = "TestingApplication"
    var leakedViews: MutableList<View?>? = mutableListOf()

    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "onTerminate: ")
        leakedViews = null
    }

    override fun unregisterActivityLifecycleCallbacks(callback: ActivityLifecycleCallbacks?) {
        super.unregisterActivityLifecycleCallbacks(callback)
        when(callback) {
        }
    }
}
class Foo: Application.ActivityLifecycleCallbacks {
    override fun onActivityStarted(activity: Activity) {
        TODO("Not yet implemented")
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun onActivityResumed(activity: Activity) {
        TODO("Not yet implemented")
    }

    override fun onActivityPaused(activity: Activity) {
        TODO("Not yet implemented")
    }

    override fun onActivityStopped(activity: Activity) {
        TODO("Not yet implemented")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        TODO("Not yet implemented")
    }

    override fun onActivityDestroyed(activity: Activity) {
        TODO("Not yet implemented")
    }
}