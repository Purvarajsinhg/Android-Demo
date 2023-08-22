package com.demo.view

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.demo.R

class CSTextViewMedium30Black(context: Context, attrs: AttributeSet? = null) :
    AppCompatTextView(context, attrs) {

    init {
        this.setTextColor(resources.getColor(R.color.txt_black))
        textSize = 30F
        setTextToTextview()
    }

    private fun setTextToTextview() {
        val typeface = Typeface.createFromAsset(context.assets, "Poppins-Medium.ttf")
        setTypeface(typeface)
    }
}