package com.example.testingproject

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null
    private lateinit var app: TestingApplication
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Foo(this).execute()
        textView = findViewById(R.id.text_view)
        app = application as TestingApplication
        app.leakedViews?.add(textView)
    }

    override fun onDestroy() {
        super.onDestroy()
        textView = null
        app.leakedViews = null
    }

    override fun unregisterActivityLifecycleCallbacks(callback: Application.ActivityLifecycleCallbacks) {
        super.unregisterActivityLifecycleCallbacks(callback)
    }
}

//class Foo(val context: Context) : AsyncTask<Context, Void, Int>() {
//    override fun doInBackground(vararg params: Context?): Int {
//        val n = context;
//        Thread.sleep(100000)
//        print("Thread is awake context is $context")
//        return -1
//    }
//
//}