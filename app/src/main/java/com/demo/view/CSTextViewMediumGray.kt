package com.demo.view

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.demo.R

class CSTextViewMediumGray (context: Context, attrs: AttributeSet? = null) :
    AppCompatTextView(context, attrs) {

    init {
        this.setTextColor(resources.getColor(R.color.txt_gray))
        textSize = 13F
        setTextToTextview()
    }

    private fun setTextToTextview() {
        val typeface = Typeface.createFromAsset(context.assets, "Poppins-Medium.ttf")
        setTypeface(typeface)
    }
}