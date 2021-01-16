package com.example.testingproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toastWithGivenName {
            toast(it)
        }
        val textView = findViewById<TextView>(R.id.hello_world)
        textView.showSnackBar("this is snackbar")
    }
}

fun Context.toast(message: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, duration)
}

inline fun toastWithGivenName(action: (String) -> Unit) {
    println("saying gouri")
    repeat(10) {
        println("creating number of $it")
        action("gourii")
    }
}