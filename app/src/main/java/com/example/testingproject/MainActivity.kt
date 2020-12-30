package com.example.testingproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import dagger.Component

const val TAG = "gouri"

@Component
interface CarFactory {
    fun getCar(): Car
    fun getWheel(): Wheel
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val car = DaggerCarFactory.create().getCar()
        Log.d(TAG, "onCreate: car $car")
        val wheel = DaggerCarFactory.create().getWheel()
        Log.d(TAG, "onCreate: wheel $wheel")
        val textView = findViewById<TextView>(R.id.textView)
        Log.d(TAG, "onCreate: textViews layout Parameters ${textView.layoutParams}")
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraint_layout)
        Log.d(TAG, "onCreate: constraintLayout $constraintLayout")
    }
}