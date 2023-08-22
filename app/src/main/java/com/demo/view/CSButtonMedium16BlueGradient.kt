package com.demo.view

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import com.demo.R

class CSButtonMedium16BlueGradient @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : androidx.appcompat.widget.AppCompatButton(context, attrs) {

    init {

        val gradient = GradientDrawable(
            GradientDrawable.Orientation.LEFT_RIGHT,
            intArrayOf(
                0XFF1094C4.toInt(),
                0XFF5347FF.toInt(),
                0XFF473AFF.toInt(),
                0XFF8F26FF.toInt(),
                0XFF7A00FD.toInt(),
                0XFFAC15B8.toInt(),
                0XFFBF1969.toInt()
            ))
        gradient.cornerRadius = 20F

        val typeface = Typeface.createFromAsset(context.assets, "Poppins-Medium.ttf")
        setTypeface(typeface)
        textSize = 16F
        background = gradient
        setTextColor(resources.getColor(R.color.white))
    }
}