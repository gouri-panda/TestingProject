package com.example.testingproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

private const val TAG = "mainactivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        processValues()
        runBlocking {
            val lengthOfString = namesFlow()
                .map { it.length }
                .filter { it < 4 }
                .collect { Log.d(TAG, "onCreate: collect $it") }
//                println(lengthOfString)
            Log.d(TAG, "onCreate: length of string $lengthOfString")
        }
        runBlocking {
            flow {
                emit("a")
                delay(100)
                emit("b")
            }.mapLatest {
                Log.d(TAG, "onCreate: started computing value")
                delay(200)
                Log.d(TAG, "onCreate: map latest $it")
            }
                .collect { Log.d(TAG, "onCreate: map latest collect $it") }
        }
    }

    fun processValues() {
        runBlocking {
            val values = getValues()
            values.forEach {
                Log.d(TAG, "processValues: $it")
            }
        }
    }

    //    suspend fun getValues(): List<Int> {
//        Log.d(TAG, "getValues: starts")
//        delay(1000)
//        return listOf(1,2,3)
//
//    }
    private suspend fun getValues(): Sequence<Int> = sequence {
        Thread.sleep(250)
        yield(1)
        Thread.sleep(250)
        yield(2)
        Thread.sleep(250)
        yield(3)
    }

    private suspend fun namesFlow() = flow {
        val names = listOf("one", "two", "three", "four", "five")
        for (name in names) {
            delay(1000)
            emit(name)
        }
    }
}