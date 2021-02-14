package com.example.testingproject

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "mainActivity"

class MainActivity : AppCompatActivity() {
    //region start of MainActivity
    private var _view: Int? = null
    val view: Int
        get() = _view!!
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _view = 4
        textView.setOnLongClickListener {
            Log.d(TAG, "onCreate: log")
            true
        }
        componentName

    }

    fun foo(planetName: Any) {
        if (planetName !is Earth) {
            throw IllegalArgumentException()
        }
        planetName.rotate()
    }
    //endregion end of mainActivity


}

