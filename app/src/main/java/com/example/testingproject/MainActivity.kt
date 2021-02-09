package com.example.testingproject

import android.os.Bundle
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.IO).launch {
            var i = 0;
            val job = launch {
                repeat(5) {
                    suspendCancellableCoroutine { cont ->
                        cont.invokeOnCancellation {
                            println("invoke on cancellation")
                            if (it != null) {
                                println("invoke on cancellation Throwable $it")
                            }
                        }
                        println("hello ${i++}")
                        Thread.sleep(500)
                    }
//                    if (!isActive) return@launch
//                    println("hello ${i++}")
//                    Thread.sleep(500)
//                    delay(500) If the Job was cancelled then it will throw [CancellationException]
                }
            }
            delay(5000)
            println("cancel")
            job.cancel()
            job.invokeOnCompletion {
                println("invoke on completion ")
                if (it != null) {
                    println("Throwable ${it.message}")
                }
            }
            println("done")
        }
    }

}

suspend fun Animation.foo() = suspendCancellableCoroutine<Unit> { cont ->
    cont.invokeOnCancellation {
        println("Can't animate")
    }

}
