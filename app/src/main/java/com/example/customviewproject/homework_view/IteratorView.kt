package com.example.customviewproject.homework_view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import com.example.customviewproject.MainActivity
import com.example.customviewproject.R
import com.example.customviewproject.iterator_game_view.FanCounter

class IteratorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var radius = 0.0f
    private var fanIterator = FanIterator(0, 0, 1)
    private var startValue = 0
    private var circlePosition = PointF(0f, 0f)
    private var buttonText = MainActivity.buttonText

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 65.0f
        typeface = Typeface.create("", Typeface.BOLD)
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        radius = (width / 10).toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (buttonText == context.getString(R.string.plus_bt)) {
            if (fanIterator.count < 10) {
                paint.color = Color.GREEN
            } else if (fanIterator.count < 20) {
                paint.color = Color.YELLOW
            } else {
                paint.color = Color.RED
            }
            if (fanIterator.count == 10) radius *= 1.4f
            else if (fanIterator.count == 20) radius *= 1.3f
        } else {
            if (fanIterator.count < 10) {
                paint.color = Color.GREEN
            } else if (fanIterator.count < 20) {
                paint.color = Color.YELLOW
            } else {
                paint.color = Color.RED
            }
            if (fanIterator.count == 20) radius /= 1.3f
            else if (fanIterator.count == 10) radius /= 1.4f
        }

        circlePosition.x = (width / 2).toFloat()
        circlePosition.y = (height / 2).toFloat()
        canvas.drawCircle(circlePosition.x, circlePosition.y, radius, paint)
        paint.color = Color.BLACK
        canvas.drawText(fanIterator.count.toString(), circlePosition.x, circlePosition.y, paint)

    }

    init {
        isClickable = true
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.IteratorView,
            0, 0
        ).apply {
            try {
                startValue = getInteger(R.styleable.IteratorView_startValue, 0)
            } finally {
                recycle()
            }
        }
    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true

        buttonText = MainActivity.buttonText
        if (buttonText == context.getString(R.string.plus_bt)) fanIterator.operation = 1
        else fanIterator.operation = -1
        contentDescription = fanIterator.next().toString()

        invalidate()
        return true
    }
}