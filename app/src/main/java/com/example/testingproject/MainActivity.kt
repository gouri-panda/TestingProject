package com.example.testingproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}