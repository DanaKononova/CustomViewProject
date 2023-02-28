package com.example.customviewproject.iterator_game_view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class CounterView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var radius = 0.0f
    private var fanCounter = FanCounter(0, 0)
    private var time = 0L
    private var firstTime = 0L
    private var circlePosition = PointF(0f, 0f)

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 65.0f
        typeface = Typeface.create("", Typeface.BOLD)
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        radius = (width/ 20).toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.BLACK
        if (time > firstTime + 30000){
            fanCounter.finalScore = fanCounter.count - 1
            canvas.drawText("End of game.\n Your score is ${fanCounter.finalScore}",
                (width/2).toFloat(), (height/3).toFloat(), paint)
        } else {
            if (fanCounter.count < 10) {
                paint.color = Color.GREEN
            } else if (fanCounter.count < 20) {
                paint.color = Color.YELLOW
            } else {
                paint.color = Color.RED
            }
            if (fanCounter.count == 10) radius *= 1.4f
            else if (fanCounter.count == 20) radius *= 1.3f

            circlePosition.x = (radius.toInt()..width - radius.toInt()).random().toFloat()
            circlePosition.y = (radius.toInt()..height - radius.toInt()).random().toFloat()
            canvas.drawCircle(circlePosition.x, circlePosition.y, radius, paint)
            paint.color = Color.BLACK
            canvas.drawText(fanCounter.count.toString(), circlePosition.x, circlePosition.y, paint)
        }
    }

    init {
        isClickable = true
    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true
        contentDescription = fanCounter.next().toString()
        time = System.currentTimeMillis()
        if (fanCounter.count == 1) firstTime = time

        invalidate()
        return true
    }
}