package com.example.testingproject

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.os.Build
import android.os.Bundle
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}

class ClockCanvas @JvmOverloads constructor(
    cont: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int =0
) : View(cont, attrs, defStyleAttr, defStyleRes) {


    private val path = Path()

    @RequiresApi(Build.VERSION_CODES.M)
    val paint = Paint().apply {
        alpha = 1
//        strokeCap = Paint.Cap.ROUND
        style = Paint.Style.STROKE
        color = context?.getColor(R.color.white)!!
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawPath(path, paint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(event.x, event.y)
            }
            MotionEvent.ACTION_UP -> {

            }
            MotionEvent.ACTION_MOVE -> {
                path.lineTo(event.x, event.y)
            }
            else -> return false
        }
        invalidate()
        return true

    }
}

