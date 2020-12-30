package com.example.testingproject

import android.util.Log
import javax.inject.Inject

class Car @Inject constructor(val wheel: Wheel, val engine: Engine) {
    init {
        Log.d(TAG, "car is getting ready: ")
    }
}

class Wheel @Inject constructor(val tyre: Tyre) {
    init {
        Log.d(TAG, "wheel is getting ready: ")
    }
}

class Engine @Inject constructor() {
    init {
        Log.d(TAG, "Engine is getting ready: ")
    }
}

class Tyre @Inject constructor() {
    init {
        Log.d(TAG, "tyre is getting ready ")
    }
}