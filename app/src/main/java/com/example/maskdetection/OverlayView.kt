package com.example.maskdetection

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class OverlayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var boundingBox: MutableList<Box> = mutableListOf()
    var paint = Paint()
    val colorMap = mapOf(
        LABEL.Mask to Color.GREEN,
        LABEL.No_Mask to Color.RED,
        LABEL.Covered_Mouth_Chin to Color.YELLOW,
        LABEL.Covered_Nose_Mouth to Color.parseColor("#FFA500")
    )

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 3f
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeMiter = 100f
        boundingBox.forEach { box ->

            paint.color = colorMap[box.label]!!

            paint.setTextAlign(Paint.Align.LEFT)
            canvas.drawText(box.description, box.rectF.left, box.rectF.top - 9F, paint)
            canvas.drawRoundRect(box.rectF, 2F, 2F, paint)
        }
    }
}