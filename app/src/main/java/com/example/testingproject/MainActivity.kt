package com.example.testingproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import java.io.IOException
import kotlin.coroutines.CoroutineContext

const val TAG = "mainactivity"

class MainActivity : AppCompatActivity() {
    private val job: Job = Job()
    private lateinit var liveData: LiveData<String>
    private lateinit var flow: Flow<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        liveData = MutableLiveData<String>()
//        val flow = flow {
//            emit("a")
//            delay(100)
//            emit("b")
//            emit("c")
//        }.flatMapLatest { value ->
//            flow {
//                emit("flatmap latest value before time delay $value")
//                delay(200)
//                emit("flatmap latest value after time delay $value")
//            }
//        }
//        lifecycleScope.launch {
//            flow.collect { value ->
//                Log.d(TAG, "onCreate: flow of $value")
//            }
//        }
        val coroutineScope = CoroutineScope(job).launch {
            withContext(Dispatchers.Main) {
                val childJob = async {
                    repeat(10) {
                        delay(1000)
                        Log.d(TAG, "onCreate: doing something")
                        if (it == 8) {
                            Log.d(TAG, "onCreate: it is 8")
                            cancel(cause = CancellationException("something went wrong"))
                        }
                    }
                }
            }
            Log.d(TAG, "onCreate: is coroutineScope is Alive ${this.isActive}")
        }

    }
}