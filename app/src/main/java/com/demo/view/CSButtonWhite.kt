package com.demo.view

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import com.demo.R

class CSButtonWhite @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : androidx.appcompat.widget.AppCompatTextView(context, attrs) {

    init {
        val typeface = Typeface.createFromAsset(context.assets, "Poppins-Medium.ttf")
        setTypeface(typeface)
        textSize = 14F
        setTextColor(resources.getColor(R.color.txt_black))
    }
}